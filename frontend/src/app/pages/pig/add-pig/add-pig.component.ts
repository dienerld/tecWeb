/* eslint-disable no-unused-expressions */
/* eslint-disable dot-notation */
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { inputPigDto } from 'src/app/dtos/pig.dto';
import { PigService } from '&services/pig.service';
import { StallService } from '&services/stall.service';

type selectHtml = {
  label: string,
  key: number
}

@Component({
  selector: 'app-add-pig',
  templateUrl: './add-pig.component.html',
  styleUrls: ['./add-pig.component.scss'],
})
export class AddPigComponent implements OnInit {
  addForm: FormGroup;

  pigId: number = undefined;

  stalls: selectHtml[] = [];

  arrSex = [{ label: 'F', key: 'F' }, { label: 'M', key: 'M' }];

  constructor(
    protected readonly pigService: PigService,
    protected readonly stallService: StallService,
    protected readonly activatedRoute: ActivatedRoute,
    protected readonly fb: FormBuilder,
    private readonly serviceTitle: Title,
    protected readonly router: Router,
  ) { }

  ngOnInit(): void {
    this.serviceTitle.setTitle('Adicionar novo Porco');
    this.addForm = this.fb.group({
      id: [],
      stallId: ['', Validators.required],
      sex: ['', Validators.required],
      weight: ['', [Validators.required]],
      lastVermifuge: ['', [Validators.required]],
      birthDate: ['', [Validators.required]],
      entryDate: ['', [Validators.required]],

    });
    this.activatedRoute.params.subscribe((params) => {
      this.pigId = params['id'];
      if (this.pigId) {
        this.pigService.getOne(this.pigId)
          .subscribe((response) => this.updateForm(response));
      }
    });

    this.stallService.getStalls().subscribe((response) => {
      response.forEach((stall) => {
        this.stalls.push({
          label: stall.name,
          key: stall.id,
        });
      });
    });
  }

  private updateForm(pig: Partial<inputPigDto>): void {
    this.addForm.patchValue({
      id: pig.id,
      stallId: {
        label: pig.stallName,
        key: pig.stallId,
      },
      sex: {
        label: pig.sex,
        key: pig.sex,
      },
      weight: pig.weight,
      entryDate: pig.entryDate,
      lastVermifuge: pig.lastVermifuge,
      birthDate: pig.birthDate,

    });
  }

  save(): void {
    if (this.addForm.valid) {
      const pig: inputPigDto = {
        id: this.pigId,
        stallName: this.addForm.value.stallId.label,
        birthDate: this.addForm.value.birthDate,
        lastVermifuge: this.addForm.value.lastVermifuge,
        weight: this.addForm.value.weight,
        sex: this.addForm.value.sex.key,
        entryDate: this.addForm.value.entryDate,
        stallId: this.addForm.value.stallId.key,
      };

      if (pig.id) {
        this.pigService.updatePig(pig)
          .subscribe((response) => {
            this.router.navigate(['/home']);
          });
      } else {
        this.pigService.createPig(pig)
          .subscribe((response) => {
            this.router.navigate(['/home']);
          });
      }
    }
  }
}
