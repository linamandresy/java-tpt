import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-swipable-card',
  templateUrl: './swipable-card.component.html',
  styleUrls: ['./swipable-card.component.scss'],
})
export class SwipableCardComponent  implements OnInit {

  @Input()
  url!:Array<string>;

  @Input()
  title!:string;

  @Input()
  subtitle!:string;

  @Input()
  description!:string;

  @Input()
  link!:string;

  
  constructor() { }

  ngOnInit() {}

}
