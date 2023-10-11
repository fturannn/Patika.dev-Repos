public class Basket {
    private Notebook notebook;
    private MobilePhone mobilePhone;

    public Basket(Notebook notebook, MobilePhone mobilePhone) {
        this.notebook = notebook;
        this.mobilePhone = mobilePhone;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public MobilePhone getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(MobilePhone mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
