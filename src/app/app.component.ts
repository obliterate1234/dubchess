import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterOutlet} from '@angular/router';
import {PlayerService} from "./service/player.service";
import {Player} from "./model/player";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {DomSanitizer, SafeHtml} from "@angular/platform-browser";
import {User} from "./model/user";
import {AuthService} from "./service/auth.service";
import {faRefresh} from "@fortawesome/free-solid-svg-icons";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";

@Component({
    selector: 'app-root',
    providers: [PlayerService, AuthService, HttpClient],
    standalone: true,
    imports: [CommonModule, RouterOutlet, HttpClientModule, FaIconComponent],
    templateUrl: './app.component.html',
    styles: [],
})
export class AppComponent implements OnInit {
    title = 'dubchess-front';
    players: Player[] = [];

    constructor(
        private playerService: PlayerService,
        private authService: AuthService,
        private domSanitizer: DomSanitizer,
        private http: HttpClient

        ) {
    }

    ngOnInit() {

        // this.authService.login("carte", "Dubchess@Passy1")
        //     .subscribe((data) => {
        //
        //     });



        // this.playerService.getPlayers().subscribe((data) => {
        //     console.log(data);
        //     this.players = data;
        // });
    }

    getPlayers() {
        this.playerService.getPlayers().subscribe((data) => {

            this.players = data;
        });
    }

    protected readonly faRefresh = faRefresh;
}
