package ru.bjcreslin.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import ru.bjcreslin.domain.enumeration.ProcedureStatus;

/**
 * A Procedure.
 */
@Entity
@Table(name = "procedure")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Procedure implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "method_for_determining_the_supplier")
    private String methodForDeterminingTheSupplier;

    @Column(name = "purchase_stage")
    private String purchaseStage;

    @Column(name = "number")
    private Long number;

    @Column(name = "electronic_site")
    private String electronicSite;

    @Column(name = "electronic_auction_subject")
    private String electronicAuctionSubject;

    @Column(name = "types_of_work")
    private String typesOfWork;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "deadline_for_submission")
    private ZonedDateTime deadlineForSubmission;

    @Column(name = "deadline_consideration")
    private ZonedDateTime deadlineConsideration;

    @Column(name = "date_of_the_electronic_auction")
    private ZonedDateTime dateOfTheElectronicAuction;

    @Column(name = "time_of_the_electronic_auction")
    private ZonedDateTime timeOfTheElectronicAuction;

    @Column(name = "initial_contract_price", precision = 21, scale = 2)
    private BigDecimal initialContractPrice;

    @Column(name = "application_security_amount", precision = 21, scale = 2)
    private BigDecimal applicationSecurityAmount;

    @Column(name = "contract_security_amount", precision = 21, scale = 2)
    private BigDecimal contractSecurityAmount;

    @Column(name = "turnaround_time")
    private String turnaroundTime;

    @Column(name = "created")
    private ZonedDateTime created;

    @Column(name = "edited")
    private ZonedDateTime edited;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProcedureStatus status;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethodForDeterminingTheSupplier() {
        return methodForDeterminingTheSupplier;
    }

    public Procedure methodForDeterminingTheSupplier(String methodForDeterminingTheSupplier) {
        this.methodForDeterminingTheSupplier = methodForDeterminingTheSupplier;
        return this;
    }

    public void setMethodForDeterminingTheSupplier(String methodForDeterminingTheSupplier) {
        this.methodForDeterminingTheSupplier = methodForDeterminingTheSupplier;
    }

    public String getPurchaseStage() {
        return purchaseStage;
    }

    public Procedure purchaseStage(String purchaseStage) {
        this.purchaseStage = purchaseStage;
        return this;
    }

    public void setPurchaseStage(String purchaseStage) {
        this.purchaseStage = purchaseStage;
    }

    public Long getNumber() {
        return number;
    }

    public Procedure number(Long number) {
        this.number = number;
        return this;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getElectronicSite() {
        return electronicSite;
    }

    public Procedure electronicSite(String electronicSite) {
        this.electronicSite = electronicSite;
        return this;
    }

    public void setElectronicSite(String electronicSite) {
        this.electronicSite = electronicSite;
    }

    public String getElectronicAuctionSubject() {
        return electronicAuctionSubject;
    }

    public Procedure electronicAuctionSubject(String electronicAuctionSubject) {
        this.electronicAuctionSubject = electronicAuctionSubject;
        return this;
    }

    public void setElectronicAuctionSubject(String electronicAuctionSubject) {
        this.electronicAuctionSubject = electronicAuctionSubject;
    }

    public String getTypesOfWork() {
        return typesOfWork;
    }

    public Procedure typesOfWork(String typesOfWork) {
        this.typesOfWork = typesOfWork;
        return this;
    }

    public void setTypesOfWork(String typesOfWork) {
        this.typesOfWork = typesOfWork;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public Procedure organizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getEmail() {
        return email;
    }

    public Procedure email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public Procedure phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public Procedure contactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public ZonedDateTime getDeadlineForSubmission() {
        return deadlineForSubmission;
    }

    public Procedure deadlineForSubmission(ZonedDateTime deadlineForSubmission) {
        this.deadlineForSubmission = deadlineForSubmission;
        return this;
    }

    public void setDeadlineForSubmission(ZonedDateTime deadlineForSubmission) {
        this.deadlineForSubmission = deadlineForSubmission;
    }

    public ZonedDateTime getDeadlineConsideration() {
        return deadlineConsideration;
    }

    public Procedure deadlineConsideration(ZonedDateTime deadlineConsideration) {
        this.deadlineConsideration = deadlineConsideration;
        return this;
    }

    public void setDeadlineConsideration(ZonedDateTime deadlineConsideration) {
        this.deadlineConsideration = deadlineConsideration;
    }

    public ZonedDateTime getDateOfTheElectronicAuction() {
        return dateOfTheElectronicAuction;
    }

    public Procedure dateOfTheElectronicAuction(ZonedDateTime dateOfTheElectronicAuction) {
        this.dateOfTheElectronicAuction = dateOfTheElectronicAuction;
        return this;
    }

    public void setDateOfTheElectronicAuction(ZonedDateTime dateOfTheElectronicAuction) {
        this.dateOfTheElectronicAuction = dateOfTheElectronicAuction;
    }

    public ZonedDateTime getTimeOfTheElectronicAuction() {
        return timeOfTheElectronicAuction;
    }

    public Procedure timeOfTheElectronicAuction(ZonedDateTime timeOfTheElectronicAuction) {
        this.timeOfTheElectronicAuction = timeOfTheElectronicAuction;
        return this;
    }

    public void setTimeOfTheElectronicAuction(ZonedDateTime timeOfTheElectronicAuction) {
        this.timeOfTheElectronicAuction = timeOfTheElectronicAuction;
    }

    public BigDecimal getInitialContractPrice() {
        return initialContractPrice;
    }

    public Procedure initialContractPrice(BigDecimal initialContractPrice) {
        this.initialContractPrice = initialContractPrice;
        return this;
    }

    public void setInitialContractPrice(BigDecimal initialContractPrice) {
        this.initialContractPrice = initialContractPrice;
    }

    public BigDecimal getApplicationSecurityAmount() {
        return applicationSecurityAmount;
    }

    public Procedure applicationSecurityAmount(BigDecimal applicationSecurityAmount) {
        this.applicationSecurityAmount = applicationSecurityAmount;
        return this;
    }

    public void setApplicationSecurityAmount(BigDecimal applicationSecurityAmount) {
        this.applicationSecurityAmount = applicationSecurityAmount;
    }

    public BigDecimal getContractSecurityAmount() {
        return contractSecurityAmount;
    }

    public Procedure contractSecurityAmount(BigDecimal contractSecurityAmount) {
        this.contractSecurityAmount = contractSecurityAmount;
        return this;
    }

    public void setContractSecurityAmount(BigDecimal contractSecurityAmount) {
        this.contractSecurityAmount = contractSecurityAmount;
    }

    public String getTurnaroundTime() {
        return turnaroundTime;
    }

    public Procedure turnaroundTime(String turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
        return this;
    }

    public void setTurnaroundTime(String turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public Procedure created(ZonedDateTime created) {
        this.created = created;
        return this;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public ZonedDateTime getEdited() {
        return edited;
    }

    public Procedure edited(ZonedDateTime edited) {
        this.edited = edited;
        return this;
    }

    public void setEdited(ZonedDateTime edited) {
        this.edited = edited;
    }

    public ProcedureStatus getStatus() {
        return status;
    }

    public Procedure status(ProcedureStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(ProcedureStatus status) {
        this.status = status;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Procedure)) {
            return false;
        }
        return id != null && id.equals(((Procedure) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Procedure{" +
            "id=" + getId() +
            ", methodForDeterminingTheSupplier='" + getMethodForDeterminingTheSupplier() + "'" +
            ", purchaseStage='" + getPurchaseStage() + "'" +
            ", number=" + getNumber() +
            ", electronicSite='" + getElectronicSite() + "'" +
            ", electronicAuctionSubject='" + getElectronicAuctionSubject() + "'" +
            ", typesOfWork='" + getTypesOfWork() + "'" +
            ", organizationName='" + getOrganizationName() + "'" +
            ", email='" + getEmail() + "'" +
            ", phone='" + getPhone() + "'" +
            ", contactPerson='" + getContactPerson() + "'" +
            ", deadlineForSubmission='" + getDeadlineForSubmission() + "'" +
            ", deadlineConsideration='" + getDeadlineConsideration() + "'" +
            ", dateOfTheElectronicAuction='" + getDateOfTheElectronicAuction() + "'" +
            ", timeOfTheElectronicAuction='" + getTimeOfTheElectronicAuction() + "'" +
            ", initialContractPrice=" + getInitialContractPrice() +
            ", applicationSecurityAmount=" + getApplicationSecurityAmount() +
            ", contractSecurityAmount=" + getContractSecurityAmount() +
            ", turnaroundTime='" + getTurnaroundTime() + "'" +
            ", created='" + getCreated() + "'" +
            ", edited='" + getEdited() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
