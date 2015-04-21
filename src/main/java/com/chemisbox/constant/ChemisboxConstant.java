package com.chemisbox.constant;

public class ChemisboxConstant {
	//Type of chemical
	public static final int INPUT = 1;
	public static final int OUTPUT = 2;
	
	// Element constant
	// Element group
	public static final int ALKADI_METALS = 0;			// KLKiem
	public static final int ALKADINE_EARTH_METALS = 1;	// KL Kiem Tho
	public static final int TRANSITION_METALS = 2; 		// KL chuyen tiep
	public static final int POOR_METALS = 3;			// KL yeu
	public static final int NON_METALS = 4;				// Phi kim
	public static final int LOID_METALS = 5;			// A Kim
	public static final int HALOGEN = 6;				// Halogen
	public static final int NOBLE_GASES = 7;			// Khi tro
	
	//Chemical group
	public static final int CHEMICAL_SALT = 8;			// Muoi
	public static final int CHEMICAL_AXIT = 9;			// Axit
	public static final int CHEMICAL_BAZO = 10;			// Bazo - kiem
	public static final int CHEMICAL_OXIT = 11;			// Oxit
	public static final int CHEMICAL_GAS = 12;			// Khi
	public static final int CHEMICAL_SINGLE = 13;		// Don chat
	
	// Element and chemical state
	public static final int UN_KNOWN = 14;				// Chua xac nhan
	public static final int SOLID_STATE = 15;			// Trang thai ran
	public static final int LIQUID_STATE = 16;			// Trang thai long
	public static final int GAS_STATE = 17;				// Trang thai khi
	
	public static final int TOTAL_CHEMICAL_RECORDS_IN_A_PAGE = 20;
	public static final int TOTAL_EQUATION_RECORDS_IN_A_PAGE = 5;
	
	// Result
	public static final int SUCCESS = 0;
	public static final int ERROR = 1;
	
	// Business
	public static final int BUSINESS_FOR_LIST = 1;
	public static final int BUSINESS_FOR_ADD = 2;
	public static final int BUSINESS_FOR_UPDATE = 3;
	public static final int BUSINESS_FOR_DELETE = 4;
	public static final int BUSINESS_FOR_LOAD_DETAILS = 5;
	
	//Api name
	public static final String ADD_EQUATION_API = "/addEquation";
	
	//Error code
	public static final String CB_001 = "CB_001";
	public static final String CB_002 = "CB_002";
	public static final String CB_003 = "CB_003";
	public static final String CB_004 = "CB_004";
	public static final String CB_005 = "CB_005";
	public static final String CB_006 = "CB_006";
	public static final String CB_007 = "CB_007";
	public static final String CB_008 = "CB_008";
	public static final String CB_009 = "CB_009";
	public static final String CB_010 = "CB_010";
}
