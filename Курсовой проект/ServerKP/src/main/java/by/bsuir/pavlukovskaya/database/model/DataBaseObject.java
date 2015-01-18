
package by.bsuir.pavlukovskaya.database.model;

public abstract class DataBaseObject {
      private int id;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "DataBaseObject{" + "id=" + id + '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    protected void setId(int id) {
        this.id = id;
    }   
    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

}
