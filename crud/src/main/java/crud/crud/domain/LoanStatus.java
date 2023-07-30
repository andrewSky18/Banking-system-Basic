package crud.crud.domain;

public enum LoanStatus {
    CREATED(100 , "Created"),
    REVISION_APPROVAL(110 , "Revision Approval"),
    CENTRAL_REVISION_APPROVAL(120 , "Central Revision Approval"),
    OFFICE_BRANCH_MANAGER_APPROVAL(140 , "Office/Branch Manager Approval"),
    ISSUANCE(200 , "Issuance");


    final private int value;
     final private String key;



    LoanStatus(int value , String key) {
        this.value = value;
        this.key = key;
    }

    public int getCode() {

        return value;
    }

    public String getKey() {
        return key;
    }
}
