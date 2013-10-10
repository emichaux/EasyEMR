package edu.wayne.cs.raptor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by Mrgadgetz
 * Date: 9/27/13
 * Time: 8:15 PM
 */

@ManagedBean
@SessionScoped
public class PageContrlr implements Serializable {

    public String moveToPagePharmacy() {
        return "pharm";
    }

    public String moveToPageTriage() {
        return "triage";
    }

    public String moveToPageMedical() {
        return "create";
    }

}
