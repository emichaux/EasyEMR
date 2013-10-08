package edu.wayne.cs.raptor;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: mrgadgetz
 * Date: 10/8/13
 * Time: 1:23 PM
 */

@ManagedBean
public class AutoCompleteDrugsBean {

    public String txt;

    public String[] drugs  = {"guaifenesin","dextromethorphan",
            "delsym", "naproxen","aleve samples",
            "ibuprofen", "children's apap",
            "metamucil", "cetirizine tabs", "preperation h",
            "naproxen sodium","motrin", "stainback headache powder",
            "enablex darifenacin","glumetza","vimovo",
            "simcor", "aanalpram kit","eye drops",
            "astepro","alendoronate sodium",
            "alendronate sodium", "detrol",
            "armour thyroid","tylenol",
            "aspirin (NSAID)", "conium maculatum",
            "graphites", "Sulphur", "activated charcoal",
            "calagesic lotion","arthritis pain relief lotion",
            "nasal decongestant spray", "nystatin",
            "evista raloxifene hcl","strattera atomoxetine hcl",
            "excedrin","advil", "tylenol xs",
            "triaminic"};


    public List<String> drugList = Arrays.asList(drugs);

    public List<String> complete(String query) {
        List<String> results = new ArrayList<String>();

        for (String drug : drugList) {
          if (drug.toLowerCase().startsWith(query.toLowerCase())) {
              results.add(drug);
          }
        }
        return results;
    }

    public List<String> complete2(String query) {
        List<String> results = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            results.add(query + i);
        }

        return results;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}

