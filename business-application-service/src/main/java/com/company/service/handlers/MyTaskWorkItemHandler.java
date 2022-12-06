package com.company.service.handlers;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.springframework.stereotype.Component;

//@Component annotation with name that matches the work item defined in Business Central
//Vamos que tiene que coincidir el nombre del componente con el del workitem que se ha definido en el kjar
@Component("MyTask")
public class MyTaskWorkItemHandler implements WorkItemHandler {

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
    	System.out.println("\n\n Método executeWorkItem de la clase MyTaskWorkItemHandler");
        System.out.println("Se ejecuta el siguiente workItem " + workItem);
        System.out.println("Primer parametro: "+workItem.getParameter("primerParam"));
        System.out.println("Segundo parametro: "+workItem.getParameter("segundoParam"));
        System.out.println("Tercer parametro: "+workItem.getParameter("tercerParam"));
        Map<String,Object> resultsMap = new HashMap<String,Object>();

        resultsMap.put("mensaje1", "Hola Proceso");
        resultsMap.put("mensaje2", "Otro mensaje");
        System.out.println("El valor de resultsMap es: "+resultsMap);
        manager.completeWorkItem(workItem.getId(), resultsMap);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {

    }

}
