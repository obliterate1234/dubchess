import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Player} from "../model/player";
import {User} from "../model/user";

@Injectable({
  providedIn: 'root',

})
export class PlayerService {

  constructor(private http: HttpClient) {}

  getPlayers(): Observable<Player[]> {

    return this.http.get<Player[]>('http://localhost:8080/api/players', { withCredentials: true});
  }






}
