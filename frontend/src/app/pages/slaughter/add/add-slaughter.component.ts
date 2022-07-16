/* eslint-disable dot-notation */
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Slaughter } from 'src/app/models/Slaughter.model';
import { SlaughterService } from '&services/slaughter.service';

@Component({
  selector: 'app-add-stall',
  templateUrl: './add-slaughter.component.html',
  styleUrls: ['./add-slaughter.component.scss'],
})
export class AddSlaughterComponent implements OnInit {
  editForm: FormGroup;

  slaughterId: number;

  constructor(
    protected readonly slaughterService: SlaughterService,
    protected readonly activatedRoute: ActivatedRoute,
    protected readonly fb: FormBuilder,
    private readonly serviceTitle: Title,
    protected readonly router: Router,

  ) { }

  ngOnInit(): void {
    this.serviceTitle.setTitle('Adicionar novo abate');
    this.editForm = this.fb.group({
      id: [],
      name: ['', [Validators.required]],
      netWeight: ['', [Validators.required]],
      date: ['', Validators.required],
      // stallId: ['', Validators.required],
      sellPrice: ['', Validators.required],

    });
    this.activatedRoute.params.subscribe((params) => {
      this.slaughterId = params['id'];
      if (this.slaughterId) {
        this.slaughterService.getSlaughter(this.slaughterId)
          .subscribe((response) => {
            console.log(response);

            this.updateForm(response);
          });
      }
    });
  }

  save(): void {
    if (this.editForm.valid) {
      const slaughter = this.editForm.value as Slaughter;
      slaughter.id = this.slaughterId;

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

  private updateForm({ date, id, netWeight, stallName, stallId, sellPrice }: Slaughter): void {
    this.editForm.patchValue({
      id,
      netWeight,
      date,
      stallName,
      sellPrice,
      stallId,
    });
  }
}
