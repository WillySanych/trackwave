import { Component, OnDestroy, OnInit } from '@angular/core';
import { select, Store } from '@ngrx/store';
import { Observable, Subscription } from 'rxjs';
import { selectedMusicSelector } from 'src/app/share/player/store/selectors';
import { MusicInterface } from 'src/app/share/types/music.interface';
import { environment } from 'src/environments/environment';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'trackwave-player',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './player.component.html',
  styleUrl: './player.component.scss'
})
export class PlayerComponent implements OnInit, OnDestroy {

  music$: Observable<MusicInterface | null>;
  audioSrcUrl: string;
  musicSubscription: Subscription;

  audioElement: HTMLAudioElement;

  isPlaying: boolean = false;
  currentTime: number = 0;
  duration: number = 0;
  volume: number = 1;
  isMuted: boolean = false;
  isLoading: boolean = false;

  constructor(
    private store: Store
  ) {
    this.audioElement = new Audio();
  }

  ngOnInit(): void {
    this.initValues();
    this.initHandlers();
  }

  ngOnDestroy(): void {
    this.musicSubscription.unsubscribe();
  }

  initValues(): void {
    this.music$ = this.store.pipe(select(selectedMusicSelector));
    this.musicSubscription = this.music$.subscribe((music: MusicInterface | null) => {
      this.audioSrcUrl = `${environment.apiUrl}/audio/get-streaming/${music?.id}`
    });
  }

  initHandlers() {
    this.audioElement.addEventListener('loadedmetadata', () => {
      this.duration = this.audioElement?.duration || 0;
    });

    this.audioElement.addEventListener('timeupdate', () => {
        this.currentTime = this.audioElement?.currentTime || 0;
      });
  }

}
