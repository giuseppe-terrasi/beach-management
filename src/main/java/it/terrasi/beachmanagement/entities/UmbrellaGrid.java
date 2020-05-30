package it.terrasi.beachmanagement.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "umbrella_grid")
public class UmbrellaGrid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int gridRow;

    private int gridColumn;

    private int capacity;

    private float price;

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return int return the gridRow
     */
    public int getGridRow() {
        return gridRow;
    }

    /**
     * @param gridRow the gridRow to set
     */
    public void setGridRow(int gridRow) {
        this.gridRow = gridRow;
    }

    /**
     * @return int return the gridColumn
     */
    public int getGridColumn() {
        return gridColumn;
    }

    /**
     * @param gridColumn the gridColumn to set
     */
    public void setGridColumn(int gridColumn) {
        this.gridColumn = gridColumn;
    }

    /**
     * @return int return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    /**
     * @return float return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

}