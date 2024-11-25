package com.med.ioc.Implementations;

import com.med.ioc.Interfaces.IData;
import com.med.ioc.Interfaces.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier {

    @Autowired
    @Qualifier("data") // we do Qualifier to eliminate the issue of which bean needs to be injected.
    private IData datacall;

    @Override
    public Double calcul() {
        System.out.println("MetierImpl calcul: ");
        double data = datacall.getData(); // calling getData() implemented
        double res = data * 15.9;
        return res;
    }

    public void setDatacall(IData datacall) {
        this.datacall = datacall;
    }
}
