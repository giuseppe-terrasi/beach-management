package it.terrasi.beachmanagement.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date fromDate;

    private Date toDate;

    private long userId;

    private int numberOfPersons;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "booking_umbrellas",
        joinColumns = @JoinColumn(name = "booking_id", referencedColumnName = "id"),
        foreignKey = @ForeignKey(name = "FK_booking_id"),
        inverseJoinColumns = @JoinColumn(name = "umbrella_grid_id", referencedColumnName = "id"),
        inverseForeignKey = @ForeignKey(name = "FK_umbrella_grid_id")
    )
    private Set<UmbrellaGrid> umbrellas;

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
     * @return int return the userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * @return int return the numberOfPersons
     */
    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    /**
     * @param numberOfPersons the numberOfPersons to set
     */
    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    /**
     * @return User return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return Set<UmbrellaGrid> return the umbrellas
     */
    public Set<UmbrellaGrid> getUmbrellas() {
        return umbrellas;
    }

    /**
     * @param umbrellas the umbrellas to set
     */
    public void setUmbrellas(Set<UmbrellaGrid> umbrellas) {
        this.umbrellas = umbrellas;
    }


    /**
     * @return Date return the fromDate
     */
    public Date getFromDate() {
        return fromDate;
    }

    /**
     * @param fromDate the fromDate to set
     */
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * @return Date return the toDate
     */
    public Date getToDate() {
        return toDate;
    }

    /**
     * @param toDate the toDate to set
     */
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

}