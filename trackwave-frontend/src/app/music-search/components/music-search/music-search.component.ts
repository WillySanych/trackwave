import { Component, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { isLoadingSelector, musicListSelector } from 'src/app/music-search/store/selectors';
import { Observable } from 'rxjs';
import { MusicInterface } from 'src/app/share/types/music.interface';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { getMusicAction } from 'src/app/music-search/store/actions/getMusic.action';
import { CommonModule } from '@angular/common';
import { musicSelectAction } from 'src/app/share/player/store/actions/musicSelect.action';
import { MusicRequestInterface } from 'src/app/music-search/types/musicRequest.interface';

@Component({
  selector: 'trackwave-music-search',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './music-search.component.html',
  styleUrl: './music-search.component.scss'
})
export class MusicSearchComponent implements OnInit {

  isLoading$: Observable<boolean>;
  musicList$: Observable<MusicInterface[] | null>;
  form: FormGroup

  constructor(
    private store: Store,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.initValues();
    this.initForm();
  }

  initForm(): void {
    this.form = this.fb.group({
      searchText: ''
    });

    this.form.valueChanges.subscribe((musicRequest: MusicRequestInterface) => {
      this.store.dispatch(getMusicAction({musicRequest}));
    });

    this.store.dispatch(getMusicAction({}));
  }

  initValues(): void {
    this.isLoading$ = this.store.pipe(select(isLoadingSelector));
    this.musicList$ = this.store.pipe(select(musicListSelector));
  }

  onMusicSelect(selectedMusic: MusicInterface) {
    this.store.dispatch(musicSelectAction({selectedMusic}));
  }
}
