package com.progra.personas.logic;

import java.util.ArrayList;

public class Doctor extends Usuario {

    public Doctor(String id, String name, String password) {
        
        super(id, password, name,"ADM");
        this.id = id;
        this.password = password;
        this.name= name;
        //this.citas = new ArrayList();
        
        
    }

    public Doctor(String id, String name, String password, String especialidad, String costoConsulta, String ubicacion, String horario, String frecuencia, String bio) {
        super(id, password, name,"ADM");
        this.name = name;
        this.id = id;
        this.password = password;
        //this.citas = new ArrayList();
        if(ubicacion == null){
            this.ubicacion=" ";
        }else{
            this.ubicacion = ubicacion;
        }
        if(especialidad == null){
            this.especialidad=" ";
        }else{
            this.especialidad = especialidad;
        }
        if(costoConsulta == null){
            this.costoConsulta=" ";
        }else{
            this.costoConsulta = costoConsulta;
        }
        if(horario == null){
            this.horario=" ";
        }else{
            this.horario = horario;
        }
        if(frecuencia == null){
            this.frecuencia=" ";
        }else{
            this.frecuencia = frecuencia;
        }
        if(bio == null){
            this.bio=" ";
        }else{
            this.bio = bio;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEspecialidad() {
        return especialidad;
    }


    public String getCostoConsulta() {
        return costoConsulta;
    }

    public void setCostoConsulta(String costoConsulta) {
        this.costoConsulta = costoConsulta;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getBio() {
        return bio;
    }
    /*public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }

    

    public void setBio(String bio) {
        this.bio = bio;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }
*/

    
    String name;
    String id;
    String password;
    
    
    //Extra
    String especialidad;
    String costoConsulta;
    String ubicacion;
    String horario;
    String frecuencia;
    String bio;
    
    
    //ArrayList<Cita> citas;



}