import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Store } from '@ngrx/store';
import { musicUploadAction } from 'src/app/music-upload/store/actions/musicUpload.action';
import { MusicUploadRequestInterface } from 'src/app/music-upload/types/musicUploadRequest.interface';

@Component({
  selector: 'trackwave-music-upload',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './music-upload.component.html',
  styleUrl: './music-upload.component.scss'
})
export class MusicUploadComponent implements OnInit {

  form: FormGroup;

  constructor(
    private store: Store,
    private fb: FormBuilder
  ) {}

  
  ngOnInit(): void {
    this.initForm();
  }
  
  initForm() {
    this.form = this.fb.group({
      author: ['', Validators.required],
      name: ['', Validators.required],
      file: ['', Validators.required]
    });
  }
  
  onFileSelect(event: Event) {
    let inputEvent = event.target as HTMLInputElement;
    if (inputEvent.files?.length) {
      this.form.patchValue({
        file: inputEvent.files[0]
      });
    }
  }

  onSubmit() {
    console.log(this.form.value);
    let musicUploadRequest: MusicUploadRequestInterface = this.form.value;
    this.store.dispatch(musicUploadAction({musicUploadRequest}));
  }
}
