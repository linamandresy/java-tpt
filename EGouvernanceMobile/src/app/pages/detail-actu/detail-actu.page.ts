import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ActuService } from 'src/app/services/actu.service';


@Component({
  selector: 'app-detail-actu',
  templateUrl: './detail-actu.page.html',
  styleUrls: ['./detail-actu.page.scss'],
})
export class DetailActuPage implements OnInit {

  actu: any = {
    title:"Actualité",
    image:["https://www.studiosifaka.org/images/cache/k2/w700_h459/a60f95e6048a6076bc6ca88177633fab.jpg"]
  };
  constructor(
    private route: ActivatedRoute,
    private actuService: ActuService
  ) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      let id = params['id'];
      this.actuService.getActuById(id).subscribe(
        (data: any) => {
          console.log(data.content);
          if (data.status == 200) {
            this.actu = data.content;
          }
        }, (err) => {
          console.log(err);
        }
      )
    });
  }

}
