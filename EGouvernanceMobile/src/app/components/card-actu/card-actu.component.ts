import { Component, Input, OnInit } from '@angular/core';
import { IonicModule } from '@ionic/angular';
@Component({
  selector: 'app-card-actu',
  templateUrl: './card-actu.component.html',
  styleUrls: ['./card-actu.component.scss'],
})
export class CardActuComponent  implements OnInit {

  @Input()
  link:string="";

  @Input()
  urlImg:string="";

  @Input()
  altImg:string="";
  
  @Input()
  title:string="";

  @Input()
  subtitle:string="";

  @Input()
  description="";
  constructor() { }

  ngOnInit() {}

}
