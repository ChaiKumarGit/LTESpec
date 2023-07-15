package chai.lte;

import java.util.List;
import java.util.Vector;

import org.w3c.dom.Element;

public class Data {
	
	static final String version = "(V1.0)";
	static final String appName = "LTESpec";
	static final String newLine = "\\r\\n|\\r|\\n";
	static final String hexStartBits = "0000 ";
	
	static String wireSharkPath = "C:\\Program Files\\Wireshark";
	static String attachHex;
	static String ueCapHex;
	
	static enum searchArrayName {ATTACHIEs, LTEUECAPIEs, BANDIEs};
	
	//User interaction IEs
	static final String[] userIIEs = {
			"Tester",
			"Date",
			"Manufacturer",
			"Device/Model",
			"Firmware",
			"Chipset",
			"RadioStack/AMSS version",
			"RRC Release",
			"Pre-IOT = Partial coverage",
			"Default APN",
			"Default APN Authentication Type",
			"SVN / Test Cycle (IOT-X/MR-X): ",
			"SIP User Agent",
			"EVS Support",
			"SMSoIP in WiFi",
			"SMSoIP in Cellular",
			"QoS 128:",
			"QoS 254:"
	};
	
	//Attach Request IEs
	static final String[][] attachIEs = {
			{"nas-eps","nas_eps.emm.eps_att_type"},
			{"nas-eps",""}
	};

	static final String[][] attachIEsShowName = {
			{
			"EPS attach type: "},
			{
			"PDN type: ",
			"EIT",
			"EEA0:",
			"128-EEA1:",
			"128-EEA2:",
			"128-EEA3:",
			"EIA0:",
			"128-EIA1:",
			"128-EIA2:",
			"128-EIA3:",
			"LCS VA capability: ",
			"PS inter-RAT HO from GERAN to UTRAN Iu mode capability:",
			"PS inter-RAT HO from GERAN to E-UTRAN S1 mode capability:",
			"EMM Combined procedures capability:",
			"ISR support:",
			"SRVCC to GERAN/UTRAN capability:",
			"EPC capability:",
			"NF capability:",
			"Additional update type",
			"AUTV: ",
			"UE's usage setting:",
			"Voice domain preference for E-UTRAN:"
			}
	};
	
	static final String[][] attachIEsExcelName = {
			{
				"EPS attach type: "},
			{
				"PDN type: ",
				"EIT",
				"EEA0:",
				"128-EEA1:",
				"128-EEA2:",
				"128-EEA3:",
				"EIA0:",
				"128-EIA1:",
				"128-EIA2:",
				"128-EIA3:",
				"LCS VA capability:",
				"PS inter-RAT HO from GERAN to UTRAN Iu mode capability:",
				"PS inter-RAT HO from GERAN to E-UTRAN S1 mode capability:",
				"EMM Combined procedures capability:",
				"ISR support:",
				"SRVCC to GERAN/UTRAN capability:",
				"EPC capability:",
				"NF capability:",
				"Additional update type",
				"AUTV: ",
				"UE's usage setting:",
				"Voice domain preference for E-UTRAN:"
			}
	};
	
	static final int[][] attachIEsEliminate = {
		{0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	};
	static final int[][] attachIEsSkipStartChars = {
		{0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	};
	static List <List> attachIEsElementList = new Vector<List>();
	static String[][][] attachIEValues = new String[attachIEs.length][][];
	
	//EO- Attach Request IEs
	
	//LTE UE Cap
	static final String[][] lteUECapIEs = {
			{"fake-field-wrapper","lte-rrc.UL_DCCH_Message_element"},
			{"fake-field-wrapper","lte-rrc.UL_DCCH_Message_element","lte-rrc.message","lte-rrc.c1","lte-rrc.ueCapabilityInformation_element","lte-rrc.criticalExtensions","lte-rrc.c1","lte-rrc.ueCapabilityInformation_r8_element","lte-rrc.ue_CapabilityRAT_ContainerList","","lte-rrc.UE_CapabilityRAT_Container_element","lte-rrc.ueCapabilityRAT_Container","lte-rrc.UE_EUTRA_Capability_element","lte-rrc.rf_Parameters_element","lte-rrc.supportedBandListEUTRA"},
			{"fake-field-wrapper","lte-rrc.UL_DCCH_Message_element"},
			{"fake-field-wrapper","lte-rrc.UL_DCCH_Message_element","lte-rrc.message","lte-rrc.c1","lte-rrc.ueCapabilityInformation_element","lte-rrc.criticalExtensions","lte-rrc.c1","lte-rrc.ueCapabilityInformation_r8_element","lte-rrc.ue_CapabilityRAT_ContainerList","","lte-rrc.UE_CapabilityRAT_Container_element","lte-rrc.ueCapabilityRAT_Container","rrc.InterRATHandoverInfo_element","rrc.ue_CapabilityContainer","rrc.UE_RadioAccessCapabilityInfo_element","rrc.ue_RadioAccessCapability_v370ext_element","rrc.ue_RadioAccessCapabBandFDDList","","rrc.UE_RadioAccessCapabBandFDD_element","rrc.measurementCapability_element","rrc.compressedModeMeasCapabGSMList"}

	};

	static final String[][] lteUECapIEsShowName = {
			{
				"accessStratumRelease:"
			},
			{
				"bandEUTRA:"
			},
			{
				"ue-Category:",
				"ue-Category-v1020:",
				"ue-Category-v1170:",
				"ue-Category-v11a0:",
				"ue-CategoryDL-r12:",
				"ue-CategoryUL-r12:",
				"ue-CategoryDL-v1260:",
				"ue-CategoryDL-v1330:",
				"ue-CategoryUL-v1430:",
				"ue-CategoryDL-v1450:",
				"alternativeTBS-Index-r14",
				"freqBandRetrieval-r11",
				"freqBandPriorityAdjustment-r12",
				"dl-256QAM-r12: ",
				"ul-64QAM-r12: ",
				"supportedROHC-Profiles",
				"maxNumberROHC-ContextSessions",
				"ue-TxAntennaSelectionSupported:",
				"ue-SpecificRefSigsSupported:",
				"interRAT-NeedForGaps:",
				"interFreqNeedForGaps:",
				"SupportedBandUTRA-FDD:",
				"enhancedDualLayerFDD-r9",
				"enhancedDualLayerTDD-r9",
				"dtm-r9",
				"e-RedirectionGERAN-r9",
				"e-RedirectionUTRA-r9",
				"intraFreqProximityIndication-r9",
				"interFreqProximityIndication-r9",
				"utran-ProximityIndication-r9",
				"intraFreqSI-AcquisitionForHO-r9",
				"interFreqSI-AcquisitionForHO-r9",
				"utran-SI-AcquisitionForHO-r9",
				"rach-Report-r9",
				"loggedMeasurementsIdle-r10",
				"standaloneGNSS-Location-r10",
				"pdcp-SN-Extension-r11",
				"supportRohcContextContinue-r11",
				"phyLayerParameters-v1130",
				"phyLayerParameters-v1170",
				"crs-InterfHandl-r11",
				"ss-CCH-InterfHandl-r11",
				"maximumCCsRetrieval-r13",
				"skipFallbackCombinations-r13",
				"reducedIntNonContComb-r13",
				"fdd-Add-UE-EUTRA-Capabilities-r9",
				"featureGroupIndicators",
				"featureGroupIndicators-r9",
				"featureGroupIndRel9Add-r9",
				"tdd-Add-UE-EUTRA-Capabilities-r9",
				"featureGroupIndRel10-r10"
			},
			{
				"radioFrequencyBandGSM: "
			}
	};
	
	static final String[][] lteUECapIEsExcelName = {
			{
				"accessStratumRelease:"
			},
			{
				"supportedBandListEUTRA:"
			},
			{
				"ue-Category:",
				"ue-Category-v1020:",
				"ue-Category-v1170:",
				"ue-Category-v11a0:",
				"ue-CategoryDL-r12:",
				"ue-CategoryUL-r12:",
				"ue-CategoryDL-v1260:",
				"ue-CategoryDL-v1330:",
				"ue-CategoryUL-v1430:",
				"ue-CategoryDL-v1450:",
				"alternativeTBS-Index-r14",
				"freqBandRetrieval-r11",
				"freqBandPriorityAdjustment-r12",
				"dl-256QAM per band:",
				"ul-64QAM per band:",
				"supportedROHC-Profiles",
				"maxNumberROHC-ContextSessions",
				"ue-TxAntennaSelectionSupported",
				"ue-SpecificRefSigsSupported",
				"interRAT-NeedForGaps:",
				"interFreqNeedForGaps:",
				"SupportedBandUTRA-FDD:",
				"enhancedDualLayerFDD-r9",
				"enhancedDualLayerTDD-r9",
				"dtm-r9",
				"e-RedirectionGERAN-r9",
				"e-RedirectionUTRA-r9",
				"intraFreqProximityIndication-r9",
				"interFreqProximityIndication-r9",
				"utran-ProximityIndication-r9",
				"intraFreqSI-AcquisitionForHO-r9",
				"interFreqSI-AcquisitionForHO-r9",
				"utran-SI-AcquisitionForHO-r9",
				"rach-Report-r9",
				"loggedMeasurementsIdle-r10",
				"standaloneGNSS-Location-r10",
				"pdcp-SN-Extension-r11",
				"supportRohcContextContinue-r11",
				"phyLayerParameters-v1130",
				"phyLayerParameters-v1170",
				"crs-InterfHandl-r11",
				"ss-CCH-InterfHandl-r11",
				"maximumCCsRetrieval-r13",
				"skipFallbackCombinations-r13",
				"reducedIntNonContComb-r13",
				"fdd-Add-UE-EUTRA-Capabilities-r9",
				"featureGroupIndicators",
				"featureGroupIndicators-r9",
				"featureGroupIndRel9Add-r9",
				"tdd-Add-UE-EUTRA-Capabilities-r9",
				"featureGroupIndRel10-r10"
			},
			{
				"Supported GSM Bands:"
			}
	};
	
	static final int[][] lteUECapIEsEliminate = {
			{0},
			{0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,3,3,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{3}
	};
	static final int[][] lteUECapIEsSkipStartChars = {
			{0},
			{0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0}
	};
	static List <List> lteUECapIEsElementList = new Vector<List>();
	static String[][][] lteUECapIEValues = new String[lteUECapIEs.length][][];
	
	//EO- LTE UE Cap

	
	//NR UE Cap
	static final String[][] nrUECapIEs = {
	};

	static final String[][] nrUECapIEsShowName = {
	};
	
	static final String[][] nrUECapIEsExcelName = {
	};
	
	static final int[][] nrUECapIEsSkipStartChars = {
	};
	static final int[][] nrUECapIEsEliminate = {
	};

	static List <List> nrUECapIEsElementList = new Vector<List>();
	static String[][][] nrUECapIEValues = new String[nrUECapIEs.length][][];
	
	//Search repeatedly for below IES in supported band list for 'n' number of times. [where 'n' is number of NR bands supported by UE]
	static final String[][] bandIEs= {
			{"","nr-rrc.BandNR_element"},
			{"","nr-rrc.BandNR_element","nr-rrc.mimo_ParametersPerBand_element"},
			{"","nr-rrc.BandNR_element","nr-rrc.mimo_ParametersPerBand_element","nr-rrc.periodicBeamReport"},
			{"","nr-rrc.BandNR_element","nr-rrc.mimo_ParametersPerBand_element","nr-rrc.maxNumberRxTxBeamSwitchDL_element"},
			{"","nr-rrc.BandNR_element","nr-rrc.mimo_ParametersPerBand_element","nr-rrc.beamReportTiming_element"},
			{"","nr-rrc.BandNR_element","nr-rrc.mimo_ParametersPerBand_element"},
			{"","nr-rrc.BandNR_element"},
			{"","nr-rrc.BandNR_element","nr-rrc.channelBWs_DL_v1530"},
			{"","nr-rrc.BandNR_element","nr-rrc.channelBWs_UL_v1530"},
			{"","nr-rrc.BandNR_element"}
	};
	
	static final String[][] bandIEsShowName = {
			{"bandNR: ","mimo-ParametersPerBand is "},
			{"maxNumberConfiguredTCIstatesPerCC: ","maxNumberActiveTCI-PerBWP: ","pusch-TransCoherence: ","aperiodicBeamReport: ","maxNumberNonGroupBeamReporting: ","maxNumberCSI-RS-SSB-CBD: "},
			{"periodicBeamReport: "},
			{"scs-15kHz: ","scs-30kHz: ","scs-60kHz: ","scs-120kHz: ","scs-240kHz: "},
			{"scs-15kHz: ","scs-30kHz: ","scs-60kHz: ","scs-120kHz: "},
			{"maxNumberSSB-CSI-RS-ResourceOneTx: ","maxNumberCSI-RS-Resource: ","maxNumberCSI-RS-ResourceTwoTx: ","supportedCSI-RS-Density: ","maxNumberAperiodicCSI-RS-Resource: ","supportedCSI-RS-ResourceList: ","maxNumberTxPortsPerResource: ","maxNumberResourcesPerBand: ","totalNumberTxPortsPerBand: ","modes: ","maxNumberCSI-RS-PerResourceSet: "},
			{"multipleTCI: ","pusch-256QAM: ","ue-PowerClass: "},
			{"scs-15kHz: ","scs-30kHz: ","scs-60kHz: ","scs-120kHz: "},
			{"scs-15kHz: ","scs-30kHz: ","scs-60kHz: ","scs-120kHz: "},
			{"maxUplinkDutyCycle-PC2-FR1: ","powerBoosting-pi2BPSK: ","rateMatchingLTE-CRS: "}
	};
	
	static final String[][] bandIEsExcelName = {
			{"NR Band ","MIMO ParametersPerBand"},
			{"maxNumberConfiguredTCIstatesPerCC ","maxNumberActiveTCI-PerBWP ","pusch-TransCoherence ","aperiodicBeamReport ","maxNumber Non Group Beam Reporting ","maxNumberCSI-RS-SSB-CBD "},
			{"periodicBeamReport "},
			{"maxNumberRxTxBeamSwitchDL-> scs-15kHz: ","maxNumberRxTxBeamSwitchDL-> scs-30kHz: ","maxNumberRxTxBeamSwitchDL-> scs-60kHz: ","maxNumberRxTxBeamSwitchDL-> scs-120kHz: ","maxNumberRxTxBeamSwitchDL-> scs-240kHz: "},
			{"beamReportTiming -> scs-15kHz: ","beamReportTiming -> scs-30kHz: ","beamReportTiming -> scs-60kHz: ","beamReportTiming -> scs-120kHz: "},
			{"maxNumberSSB-CSI-RS-ResourceOneTx: ","maxNumberCSI-RS-Resource: ","maxNumberCSI-RS-ResourceTwoTx: ","supportedCSI-RS-Density: ","maxNumberAperiodicCSI-RS-Resource: ","codebookParameters (Type1 singlePanel) -> supportedCSI-RS-ResourceList: ","codebookParameters (Type1 singlePanel) -> maxNumberTxPortsPerResource: ","codebookParameters (Type1 singlePanel) -> maxNumberResourcesPerBand: ","codebookParameters (Type1 singlePanel) -> totalNumberTxPortsPerBand: ","codebookParameters (Type1 singlePanel) -> modes: ","codebookParameters (Type1 singlePanel) -> maxNumberCSI-RS-PerResourceSet: "},
			{"multipleTCI: ","pusch-256QAM: ","ue-PowerClass: "},
			{"channelBWsDL ( FR1: 5,10,15,20,25,30,40,50,60 and 80MHz | FR2: 50,100 and 200MHz) -> scs-15kHz: ","channelBWsDL ( FR1: 5,10,15,20,25,30,40,50,60 and 80MHz | FR2: 50,100 and 200MHz) -> scs-30kHz: ","channelBWsDL ( FR1: 5,10,15,20,25,30,40,50,60 and 80MHz | FR2: 50,100 and 200MHz) -> scs-60kHz: ","channelBWsDL ( FR1: 5,10,15,20,25,30,40,50,60 and 80MHz | FR2: 50,100 and 200MHz) -> scs-120kHz: "},
			{"channelBWsUL ( FR1: 5,10,15,20,25,30,40,50,60 and 80MHz | FR2: 50,100 and 200MHz) -> scs-15kHz: ","channelBWsUL ( FR1: 5,10,15,20,25,30,40,50,60 and 80MHz | FR2: 50,100 and 200MHz) -> scs-30kHz: ","channelBWsUL ( FR1: 5,10,15,20,25,30,40,50,60 and 80MHz | FR2: 50,100 and 200MHz) -> scs-60kHz: ","channelBWsUL ( FR1: 5,10,15,20,25,30,40,50,60 and 80MHz | FR2: 50,100 and 200MHz) -> scs-120kHz: "},
			{"maxUplinkDutyCycle-PC2-FR1: ","powerBoosting-pi2BPSK: ", "rateMatchingLTE-CRS: "}
	};
	static final int[][] bandIEsSkipStartChars = {
			{0,0},
			{0,0,0,0,0,0},
			{0},
			{0,0,0,0,0},
			{0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0},
			{3,3,3,3},
			{3,3,3,3},
			{0,0,0}
	};
	static final int[][] bandIEsEliminate = {
			{0,1},
			{3,3,3,3,3,0},
			{3},
			{3,3,3,3,3},
			{3,3,3,3},
			{3,3,3,3,3,0,3,0,0,3,0},
			{3,3,3},
			{0,0,0,0},
			{0,0,0,0},
			{3,3,3}
	};
	
	static List <List<List>> bandIEsElementList = new Vector<List<List>>();
	static String[][][][] bandIEValues;
	
	//EO- NR UE Cap
	
	static void createElementList() {
		//Attach Request
		for(int index=0; index<attachIEs.length; index++) {
			List<Element> empty = new Vector<Element>();	
			attachIEsElementList.add(empty);
		}
		
		for(int index =0; index<attachIEValues.length; index++) {
			attachIEValues[index] = new String[attachIEsShowName[index].length][];
			for(int rowIndex =0; rowIndex<attachIEValues[index].length; rowIndex++) {
				attachIEValues[index][rowIndex] = new String[1];
				attachIEValues[index][rowIndex][0] = "No Information";
			}
		}
		
		//lte UE Cap
		for(int index=0; index<lteUECapIEs.length; index++) {
			List<Element> empty = new Vector<Element>();	
			lteUECapIEsElementList.add(empty);
		}
		
		for(int index =0; index<lteUECapIEValues.length; index++) {
			lteUECapIEValues[index] = new String[lteUECapIEsShowName[index].length][];
			for(int rowIndex =0; rowIndex<lteUECapIEValues[index].length; rowIndex++) {
				lteUECapIEValues[index][rowIndex] = new String[1];
				lteUECapIEValues[index][rowIndex][0] = "No Information";
			}
		}
		
		//nr UE Cap
		for(int index=0; index<nrUECapIEs.length; index++) {
			List<Element> empty = new Vector<Element>();	
			nrUECapIEsElementList.add(empty);
		}
		
		for(int index =0; index<nrUECapIEValues.length; index++) {
			nrUECapIEValues[index] = new String[nrUECapIEsShowName[index].length][];
			for(int rowIndex =0; rowIndex<nrUECapIEValues[index].length; rowIndex++) {
				nrUECapIEValues[index][rowIndex] = new String[1];
				nrUECapIEValues[index][rowIndex][0] = "No Information";
			}
		}

	}

}
