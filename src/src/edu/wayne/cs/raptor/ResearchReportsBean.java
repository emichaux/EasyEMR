package edu.wayne.cs.raptor;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.hibernate.Session;


public class ResearchReportsBean {

	PharmacyEncounter ec = new PharmacyEncounter();

	

	public static void generateConditionReport() {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setSelectedFile(new File(suggestFileName()
				+ "-EncounterExport.csv"));
		int returnValue = jFileChooser.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jFileChooser.getSelectedFile();
			generateConditionFile(selectedFile); 
		}
	}

	@SuppressWarnings("unchecked")
	private static void generateConditionFile(File filehandle) {
		try {
			FileWriter writer = new FileWriter(filehandle);

			// Get Data from raptor

			Session userSession = HibernateUtil.getSessionFactory()
					.openSession();
			userSession.beginTransaction();

			List<Encounter> dbencounter = userSession.createQuery("from Encounter").list();
			//List<PharmacyEncounter> dbpharm = userSession.createQuery("from PharmacyEncounter").list();
			List<Patient>dbPatient = userSession.createQuery("from Patient").list();
			List<Vitals>dbVitals = userSession.createQuery("from Vitals").list();
			userSession.getTransaction().commit();
			userSession.close();

			

			writer.append("Encounter ID");
			writer.append(',');
			writer.append("Location");
			writer.append(',');
			writer.append("Birth Date");
			writer.append(',');
			writer.append("Gender");
			writer.append(',');
			writer.append("Height");
			writer.append(',');
			writer.append("Weight");
			writer.append(',');
		
			writer.append("Blood Pressure (mmHg)");
			writer.append(',');
			writer.append("Heart Rate (bpm)");
			writer.append(',');
			writer.append("Temperature (F)");
			writer.append(',');
			writer.append("Respirations (Breaths per Minute)");
			writer.append(',');
			writer.append("Oxygen (%)");
			writer.append(',');
			writer.append("Blood Sample #");
			writer.append(',');
			writer.append("Malaria");
			writer.append(',');
			writer.append("Dengue");
			writer.append(',');
			writer.append("Chief Complaint");
			writer.append(',');
			writer.append("Onset");
			writer.append(',');
			writer.append("Severity");
			writer.append(',');
			writer.append("Radiation");
			writer.append(',');
			writer.append("Quality");
			writer.append(',');
			writer.append("Provokes/Palliates");
			writer.append(',');
			writer.append("Time of Day"); 
			writer.append(',');
			writer.append("Other");
			writer.append(',');
			writer.append("Physical Examination");
			writer.append(',');
			writer.append("Assessment");
			writer.append(',');
			writer.append("Medication Prescribed 1");
			writer.append(',');
			writer.append("Medication Prescribed 2");
			writer.append(',');
			writer.append("Medication Prescribed 3");
			writer.append(',');
			writer.append("Medication Prescribed 4");
			writer.append(',');
			writer.append("Medication Prescribed 5");
			writer.append(',');
			writer.append("Other Condition1");
			writer.append(',');
			writer.append("Other Condition2");
			writer.append(',');
			writer.append("Other Condition3");
			writer.append(',');
			writer.append("Other Condition4");
			writer.append(',');
			writer.append("Other Condition5");
			writer.append(',');
		
			
			writer.append("Treatment Given");
			writer.append(',');
			writer.append("Family/Social History");

			writer.append('\n');

			for (int i = 0; i < dbencounter.size(); i++) {
				
				writer.append(String.valueOf(dbencounter.get(i).getEncounterID()));
				writer.append(',');
				writer.append(dbPatient.get(i).getResidence());
				writer.append(',');
				writer.append(dbPatient.get(i).getBirthDate());
				writer.append(',');
				writer.append(dbPatient.get(i).getGender());
				writer.append(',');
				writer.append(String.valueOf(dbVitals.get(i).getHeight()));
				writer.append(',');
				writer.append(String.valueOf(dbVitals.get(i).getWeight()));
				writer.append(',');
				
				writer.append(String.valueOf(dbVitals.get(i).getSystolicBP()+"/"+String.valueOf(dbVitals.get(i).getDiastolicBP())));
				writer.append(',');
				writer.append(String.valueOf(dbVitals.get(i).getHeartRate()));
				writer.append(',');
				writer.append(String.valueOf(dbVitals.get(i).getTemperatureF()));
				writer.append(',');
				writer.append(String.valueOf(dbVitals.get(i).getRespRate()));
				writer.append(',');
				writer.append(String.valueOf(dbVitals.get(i).getOximetry()));
				writer.append(',');
				
				writer.append(String.valueOf(dbVitals.get(i).getBloodSampleID()));
				writer.append(',');
				writer.append(String.valueOf(dbVitals.get(i).getMalaria()));
				writer.append(',');
				writer.append(String.valueOf(dbVitals.get(i).getDengue()));
				writer.append(',');
				writer.append(dbencounter.get(i).getChiefComplaint());
				writer.append(',');
				writer.append(dbencounter.get(i).getOnsetNumber()+" "+String.valueOf(dbencounter.get(i).getOnsetUnit()));
				writer.append(',');
				writer.append(String.valueOf(dbencounter.get(i).getSeverity()));
				writer.append(',');
				writer.append(dbencounter.get(i).getRadiation());
				writer.append(',');
				writer.append(dbencounter.get(i).getQuality());
				writer.append(',');
				writer.append(dbencounter.get(i).getProvokes());
				writer.append(',');
				writer.append(dbencounter.get(i).getTimeOfDay());
				writer.append(',');
				writer.append(dbencounter.get(i).getOther());
				writer.append(',');
				writer.append(dbencounter.get(i).getOverallImpression());
				writer.append(',');
				writer.append(dbencounter.get(i).getAssessment());
				writer.append(',');
				writer.append(dbencounter.get(i).getMedicationPrescribed1());
				writer.append(',');
				writer.append(dbencounter.get(i).getMedicationPrescribed2());
				writer.append(',');
				writer.append(dbencounter.get(i).getMedicationPrescribed3());
				writer.append(',');
				writer.append(dbencounter.get(i).getMedicationPrescribed4());
				writer.append(',');
				writer.append(dbencounter.get(i).getMedicationPrescribed5());
				writer.append(',');
				writer.append(dbencounter.get(i).getCondition1());
				writer.append(',');
				writer.append(dbencounter.get(i).getCondition2());
				writer.append(',');
				writer.append(dbencounter.get(i).getCondition3());
				writer.append(',');
				writer.append(dbencounter.get(i).getCondition4());
				writer.append(',');
				writer.append(dbencounter.get(i).getCondition5());
				writer.append(',');
				writer.append(dbencounter.get(i).getMedicalProcedures());
				writer.append(',');
				writer.append(dbPatient.get(i).getSocialHistory());
				writer.append(',');

				writer.append('\n');
			}

			writer.flush();
			writer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Report Saved!", "Success!", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void generateRxReport() {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setSelectedFile(new File(suggestFileName()
				+ "-RxExport.csv"));
		int returnValue = jFileChooser.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jFileChooser.getSelectedFile();
			generateRxFile(selectedFile); 
		}
	}

	
	@SuppressWarnings("unchecked")
	private static void generateRxFile(File filehandle) {
		try {
			FileWriter writer = new FileWriter(filehandle);

			// Get Data from raptor

			Session userSession = HibernateUtil.getSessionFactory()
					.openSession();
			userSession.beginTransaction();

			List<PharmacyEncounter> dbpharm = userSession.createQuery("from PharmacyEncounter").list();
			userSession.getTransaction().commit();
			userSession.close();

			

			
			writer.append("Encounter ID");
			writer.append(',');
			//writer.append("Rx Prescribed 1");
			//writer.append(',');
			writer.append("RX Dispensed 1");
			writer.append(',');
			writer.append("RX Equal to Prescribed 1");
			writer.append(',');
			//writer.append("Rx Prescribed 2");
			//writer.append(',');
			writer.append("RX Dispensed 2");
			writer.append(',');
			writer.append("RX Equal to Prescribed 2");
			writer.append(',');
			//writer.append("Rx Prescribed 3");
			//writer.append(',');
			writer.append("RX Dispensed 3");
			writer.append(',');
			writer.append("RX Equal to Prescribed 3");
			writer.append(',');
			//writer.append("Rx Prescribed 4");
			//writer.append(',');
			writer.append("RX Dispensed 4");
			writer.append(',');
			writer.append("RX Equal to Prescribed 4");
			writer.append(',');
			//writer.append("Rx Prescribed 5");
			//writer.append(',');
			writer.append("RX Dispensed 5");
			writer.append(',');
			writer.append("RX Equal to Prescribed 5");
			writer.append(',');
			
		

			writer.append('\n');

			for (int i = 0; i < dbpharm.size(); i++) {
					
				writer.append(String.valueOf(dbpharm.get(i).getEncounterID()));
				writer.append(',');
				//writer.append(dbencounter.get(i).getMedicationPrescribed1());
				//writer.append(',');
				writer.append(dbpharm.get(i).getMedDispensed1());
				writer.append(',');
				writer.append(String.valueOf(dbpharm.get(i).getEqualPrescribed1()));
				writer.append(',');
				//writer.append(dbencounter.get(i).getMedicationPrescribed2());
				//writer.append(',');
				writer.append(dbpharm.get(i).getMedDispensed2());
				writer.append(',');
				writer.append(String.valueOf(dbpharm.get(i).getEqualPrescribed2()));
				writer.append(',');
				//writer.append(dbencounter.get(i).getMedicationPrescribed3());
				//writer.append(',');
				writer.append(dbpharm.get(i).getMedDispensed3());
				writer.append(',');
				writer.append(String
						.valueOf(dbpharm.get(i).getEqualPrescribed3()));
				writer.append(',');
				//writer.append(dbencounter.get(i).getMedicationPrescribed4());
				//writer.append(',');
				writer.append(dbpharm.get(i).getMedDispensed4());
				writer.append(',');
				writer.append(String.valueOf(dbpharm.get(i).getEqualPrescribed4()));
				writer.append(',');
				//writer.append(dbencounter.get(i).getMedicationPrescribed5());
				//writer.append(',');
				writer.append(dbpharm.get(i).getMedDispensed5());
				writer.append(',');
				writer.append(String.valueOf(dbpharm.get(i).getEqualPrescribed5()));
			
						

				writer.append('\n');
			}

			writer.flush();
			writer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Report Saved!", "Success!", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private static String suggestFileName() {

		String sfilename = "";
		Calendar rightNow = Calendar.getInstance();

		// get the date
		int temp_int = rightNow.get(Calendar.YEAR);
		sfilename = sfilename + temp_int;
		temp_int = rightNow.get(Calendar.MONTH);
		temp_int++;
		if (temp_int < 10)
			sfilename = sfilename + "0";
		sfilename = sfilename + temp_int;
		temp_int = rightNow.get(Calendar.DAY_OF_MONTH);
		if (temp_int < 10)
			sfilename = sfilename + "0";
		sfilename = sfilename + temp_int + "-";
		// Get the time
		temp_int = rightNow.get(Calendar.HOUR);
		if (rightNow.get(Calendar.AM_PM) == 0) {
			if (temp_int < 10)
				sfilename = sfilename + "0";
		} else
			temp_int = temp_int + 12;

		sfilename = sfilename + temp_int;
		temp_int = rightNow.get(Calendar.MINUTE);
		sfilename = sfilename + temp_int;
		temp_int = rightNow.get(Calendar.SECOND);
		if (temp_int < 10)
			sfilename = sfilename + "0" + temp_int;
		else
			sfilename = sfilename + temp_int;

		return sfilename;
	}

}