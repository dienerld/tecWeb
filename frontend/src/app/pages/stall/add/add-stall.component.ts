/* eslint-disable dot-notation */
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Stall } from 'src/app/models/Stall.model';
import { Title } from '@angular/platform-browser';
import { StallService } from '&services/stall.service';

@Component({
  selector: 'app-add-stall',
  templateUrl: './add-stall.component.html',
  styleUrls: ['./add-stall.component.scss'],
})
export class AddStallComponent implements OnInit {
  editForm: FormGroup;

  stallId: number;

  constructor(
    protected readonly stallService: StallService,
    protected readonly activatedRoute: ActivatedRoute,
    protected readonly fb: FormBuilder,
    private readonly serviceTitle: Title,
    protected readonly router: Router,

  ) { }

  ngOnInit(): void {
    this.serviceTitle.setTitle('Add Baias');
    this.editForm = this.fb.group({
      id: [],
      name: ['', [Validators.required]],
    });
    this.activatedRoute.params.subscribe((params) => {
      this.stallId = params['id'];
      if (this.stallId) {
        this.stallService.getStall(this.stallId)
          .subscribe((response) => {
            this.updateForm(response);
          });
      }
    });
  }

  save(): void {
    if (this.editForm.valid) {
      const stall = this.editForm.value as Stall;
      stall.id = this.stallId;

      if (stall.id) {
        this.stallService.updateStall(stall)
          .subscribe((response) => {
            this.router.navigate(['/stalls']);
          });
      } else {
        this.stallService.createStall(stall)
          .subscribe((response) => {
            this.router.navigate(['/stalls']);
          });
      }
    }
  }

  private updateForm(stall: Stall): void {
    this.editForm.patchValue({
      id: stall.id,
      name: stall.name,
      weightAverage: stall.weightAverage,
    });
  }
}
