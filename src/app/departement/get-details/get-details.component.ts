import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import html2canvas from 'html2canvas';
import jsPDF from 'jspdf';
import { Departement } from 'src/Models/Departement';
import { DepartementService } from '../departement.service';

@Component({
  selector: 'app-get-details',
  templateUrl: './get-details.component.html',
  styleUrls: ['./get-details.component.css']
})
export class GetDetailsComponent implements OnInit {

  id!:number;
  departement !:Departement;
  isLoading = true;
  @ViewChild('content') content!: ElementRef;  


 
  constructor(private route:ActivatedRoute, private service:DepartementService,private router:Router) { }



  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.GetAllIvoice();

  }
  GetAllIvoice()
  {
    this.service.fetchDepartementById(this.id).subscribe((res:any)=>{

    this.departement = res;
    this.departement.idDepart = res.id;

    this.isLoading = false;
    
  },
  (error)=>{
    console.log(error)
  
  });
}
 
  Delete(idDepart:number)
  {
    this.service.deleteDepartement(this.id).subscribe(()=>{},(error)=>{console.log(error)});
    // this.router.navigateByUrl('/departement/DepartementHome/getParent');
    this.reload('/departement/DepartementHome/getParent')
    
  }
  async reload(url: string): Promise<boolean> {
    await this.router.navigateByUrl('/', { skipLocationChange: true });
    return this.router.navigateByUrl(url);
  }
  Update(idDepart:number)
  {
    
    this.router.navigate(['/departement/DepartementHome/update/',this.id])
  }
 

  public SavePDF()
  {

  var element = document.getElementById('contentToConvert') as HTMLElement;
  html2canvas(element).then(canvas => {
    var imgW = 200;
    var imgH = canvas.height * imgW /canvas.width	;
    const contentDataURL = canvas.toDataURL('image/png')
    let pdf = new jsPDF('p','mm','a4');
    var position = 0;
    pdf.addImage(contentDataURL,'PNG',0,position,imgW,imgH)
    pdf.save(this.departement.nomDepart+".pdf");  
  });
}
  
}

