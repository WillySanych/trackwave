import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MusicRequestInterface } from 'src/app/music-search/types/musicRequest.interface';
import { MusicInterface } from 'src/app/share/types/music.interface';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MusicSearchService {

  constructor(private httpClient: HttpClient) { }

  getMusic(request?: MusicRequestInterface): Observable<MusicInterface[]> {
    let url = `${environment.apiUrl}/audio/get?`;

    if (request?.searchText) {
      url = url.concat(`searchText=${request?.searchText}`);
    }

    return this.httpClient.get<MusicInterface[]>(url);
  }
}
