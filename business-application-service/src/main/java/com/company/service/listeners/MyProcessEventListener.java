package com.company.service.listeners;

import org.kie.api.event.process.ProcessCompletedEvent;
import org.kie.api.event.process.ProcessEventListener;
import org.kie.api.event.process.ProcessNodeLeftEvent;
import org.kie.api.event.process.ProcessNodeTriggeredEvent;
import org.kie.api.event.process.ProcessStartedEvent;
import org.kie.api.event.process.ProcessVariableChangedEvent;
import org.springframework.stereotype.Component;

@Component
public class MyProcessEventListener implements ProcessEventListener {

    @Override
    public void beforeProcessStarted(ProcessStartedEvent event) {
        System.out.println("\n Antes del arranque del proceso con identificador: " + event.getProcessInstance().getProcess().getId());
        System.out.println("Id de la instancia del proceso: "+event.getProcessInstance().getId()+"\n");
    }

    @Override
    public void afterProcessStarted(ProcessStartedEvent event) {
        System.out.println("\n Después de que arranque el proceso " + event.getProcessInstance().getProcess().getId());
        System.out.println("Id de la instancia del proceso: "+event.getProcessInstance().getId());
        System.out.println("Se arranca en el instante: "+event.getEventDate()+"\n");
    }

    @Override
    public void beforeProcessCompleted(ProcessCompletedEvent event) {
    	 System.out.println("\n Antes de completar el proceso " + event.getProcessInstance().getProcess().getId());
         System.out.println("Id de la instancia del proceso: "+event.getProcessInstance().getId()+"\n");
    }

    @Override
    public void afterProcessCompleted(ProcessCompletedEvent event) {
    	 System.out.println("\n Después de completar el proceso: " + event.getProcessInstance().getProcess().getId());
         System.out.println("Id de la instancia del proceso: "+event.getProcessInstance().getId());
         System.out.println("Se completa en el instante: "+event.getEventDate()+"\n");
    }

    @Override
    public void beforeNodeTriggered(ProcessNodeTriggeredEvent event) {
        System.out.println("beforeNodeTriggered " + event);
    }

    @Override
    public void afterNodeTriggered(ProcessNodeTriggeredEvent event) {
        System.out.println("afterNodeTriggered " + event);
    }

    @Override
    public void beforeNodeLeft(ProcessNodeLeftEvent event) {
        System.out.println("beforeNodeLeft " + event);
    }

    @Override
    public void afterNodeLeft(ProcessNodeLeftEvent event) {
        System.out.println("afterNodeLeft " + event);
    }

    @Override
    public void beforeVariableChanged(ProcessVariableChangedEvent event) {
    	System.out.println("\n Antes de que la variable con id: "+event.getVariableId()+ " cambie, en el instante "+event.getEventDate()+"\n");
    }

    @Override
    public void afterVariableChanged(ProcessVariableChangedEvent event) {
    	System.out.println("\n Después de que la variable con id: "+event.getVariableId()+ " cambie, en el instante "+event.getEventDate());
    	System.out.println("En el proceso: "+event.getProcessInstance().getProcessId());
    	System.out.println("Valor anterior: "+event.getOldValue()+" Nuevo valor: "+event.getNewValue()+"\n");
    }

}
