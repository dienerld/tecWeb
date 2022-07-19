/* eslint-disable dot-notation */
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Slaughter } from 'src/app/models/Slaughter.model';
import { SlaughterService } from '&services/slaughter.service';
import { StallService } from '&services/stall.service';
import { PigService } from '&services/pig.service';

type selectHtml = {
  label: string,
  key: number
}

@Component({
  selector: 'app-add-stall',
  templateUrl: './add-slaughter.component.html',
  styleUrls: ['./add-slaughter.component.scss'],
})
export class AddSlaughterComponent implements OnInit {
  addForm: FormGroup;

  slaughterId: number;

  @Input()
    selectedNode;

  @Input()
    selectedPig;

  stalls: selectHtml[] = [];

  pigs: selectHtml[] = [];

  constructor(
    protected readonly slaughterService: SlaughterService,
    protected readonly stallService: StallService,
    protected readonly pigService: PigService,

    protected readonly activatedRoute: ActivatedRoute,
    protected readonly fb: FormBuilder,
    private readonly serviceTitle: Title,
    protected readonly router: Router,

  ) { }

  ngOnInit(): void {
    this.serviceTitle.setTitle('Adicionar novo abate');
    this.addForm = this.fb.group({
      id: [],
      pigId: ['', [Validators.required]],
      netWeight: ['', [Validators.required]],
      date: ['', Validators.required],
      stallId: ['', Validators.required],
      sellPrice: ['', Validators.required],

    });
    this.activatedRoute.params.subscribe((params) => {
      this.slaughterId = params['id'];
      if (this.slaughterId) {
        this.slaughterService.getSlaughter(this.slaughterId)
          .subscribe((response) => {
            this.updateForm(response);
          });
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

  save(): void {
    if (this.addForm.valid) {
      const slaughter = this.addForm.value as Slaughter;
      slaughter.stallId = this.addForm.value.stallId.key;
      slaughter.stallName = this.addForm.value.stallId.label;
      slaughter.id = this.slaughterId;
      slaughter.pigId = this.addForm.value.pigId.key;

      if (slaughter.id) {
        this.slaughterService.updateSlaughter(slaughter)
          .subscribe((response) => {
            this.router.navigate(['/slaughters']);
          });
      } else {
        this.slaughterService.createSlaughter(slaughter)
          .subscribe((response) => {
            this.router.navigate(['/slaughters']);
          });
      }
    }
  }

  private updateForm({ date, id, netWeight, stallId, sellPrice }: Slaughter): void {
    this.addForm.patchValue({
      id,
      netWeight,
      date,
      sellPrice,
      stallId,
    });
  }

  onNodeSelect(event : any): void {
    this.pigService.getPigsForStall(event.node.key).subscribe((response) => {
      this.pigs = [];
      response.forEach((pig) => {
        this.pigs.push({
          label: String(pig.id),
          key: pig.id,
        });
      });
    });
  }
}
