import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MusicUploadRequestInterface } from 'src/app/music-upload/types/musicUploadRequest.interface';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MusicUploadService {

  constructor(private httpClient: HttpClient) { }

  uploadMusic(request: MusicUploadRequestInterface): Observable<{}> {
    let url = `${environment.apiUrl}/audio/upload`;

    let formData: FormData = new FormData();
    formData.append('author', request.author);
    formData.append('name', request.name);
    formData.append('file', request.file);

    console.log(formData);
    
    return this.httpClient.post(url, formData);
  }
}
