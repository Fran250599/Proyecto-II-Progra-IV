const draggable = document.querySelectorAll('.draggable');
const container = document.querySelectorAll('.container');
var idDrag = "";
var idUndrag = "";
function Rellenar(horafinals, horas,frecuencias){
    var horaFinal = parseInt(horafinals)
    var cont = 0;
    var hora = parseInt(horas) ; 
    var minutos = 0;
    var frecuencia = parseInt(frecuencias);
    var terminacion = "am";

    for(let i = hora; i<horaFinal; i+frecuencia){
        const tabla = document.getElementById('Tabla');
        if(hora <11){
            terminacion = "am";
        }else{
            terminacion = "pm";
        }
        if(minutos === 0){
            tabla.innerHTML += `<tr class="container">
            <td>${hora}:00 ${terminacion}</td>  
            <td draggable="true"  class="draggable" id="Hola" value="8:00am">Jeaustin Rodriguez Rodriguez${cont+1}</td>
            <td draggable="true"  class="draggable" id="Hola2"></td>
            <td draggable="true"  class="draggable" id="Hola3"></td>
            <td draggable="true"  class="draggable" id="Hola4"></td>
            <td draggable="true"  class="draggable" id="Hola5"></td>
            <td draggable="true"  class="draggable" id="Hola6"></td>
            <td draggable="true"  class="draggable" id="Hola7"></td>
            </tr>`;
        }else{
            tabla.innerHTML += `<tr class="container">
            <td>${hora}:${minutos} ${terminacion}</td>  
            <td draggable="true"  class="draggable" id="Hola" value="8:00am">Jeaustin Rodriguez Rodriguez${cont+1}</td>
            <td draggable="true"  class="draggable" id="Hola2"></td>
            <td draggable="true"  class="draggable" id="Hola3"></td>
            <td draggable="true"  class="draggable" id="Hola4"></td>
            <td draggable="true"  class="draggable" id="Hola5"></td>
            <td draggable="true"  class="draggable" id="Hola6"></td>
            <td draggable="true"  class="draggable" id="Hola7"></td>
            </tr>`;
        }
   
    
    minutos +=frecuencia;
    if(minutos>=60){
        minutos = minutos - 60;
        hora += + 1;
    }
    cont = cont +1;
    if(hora === 23){
        break;
    }
    if(hora > horaFinal|| (hora === horaFinal && minutos != 0)){
        break;
    }

    }

}

function dragdrop(e){
    var dragSrcEl = null;
    function handleDragStart(e) {
        this.style.opacity = '0.4';
        
        dragSrcEl = this;
    
        e.dataTransfer.effectAllowed = 'move';
        e.dataTransfer.setData('text/html', this.innerHTML);
        idDrag = dragSrcEl.id;
        idUndrag = this.id;
        
  
      }
    
      function handleDragOver(e) {
          
        if (e.preventDefault) {
          e.preventDefault();
        }
    
        e.dataTransfer.dropEffect = 'move';
        //console.log(e); posible
        
        return false;
      }
    
      function handleDragEnter(e) {
        this.classList.add('over');
      }
    
      function handleDragLeave(e) {
        e.target.id = idDrag;
        this.classList.remove('over');
      }
    
      function handleDrop(e) {
        console.log(e);
        if (e.stopPropagation) {
            
            e.stopPropagation(); // stops the browser from redirecting.
        }
        
        if (dragSrcEl != this) {
          dragSrcEl.innerHTML = this.innerHTML;
          this.innerHTML = e.dataTransfer.getData('text/html');
          e.target.id = idUndrag;
        }
        
        return false;
      }
    
      function handleDragEnd(e) {
        this.style.opacity = '1';
        
        items.forEach(function (item) {

          item.classList.remove('over');
        });
        console.log(idDrag);
      }
      
      
      let items = document.querySelectorAll('.container .draggable');
      items.forEach(function(item) {
        item.addEventListener('dragstart', handleDragStart, false);
        item.addEventListener('dragenter', handleDragEnter, false);
        item.addEventListener('dragover', handleDragOver, false);
        item.addEventListener('dragleave', handleDragLeave, false);
        item.addEventListener('drop', handleDrop, false);
        item.addEventListener('dragend', handleDragEnd, false);
      });
}

document.addEventListener('DOMContentLoaded', (e) => {
    event.preventDefault();
    var horaInicio;
    var horaFinal;
    var Frecuencia;
    var cont = 0;
    var horaInicio = prompt("Igrese la hora de inicio",0);
    var horaFinal = prompt("Igrese la hora de finalizacion",0);
    var Frecuencia = prompt("Igrese la frecuencia de citas en minutos no mas de 60",0);

  
    



    Rellenar(horaFinal,horaInicio,Frecuencia);
    
    dragdrop(e);
   
  });
  
