package ru.bjcreslin.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.bjcreslin.web.rest.TestUtil.sameInstant;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import ru.bjcreslin.VHelperApp;
import ru.bjcreslin.domain.Procedure;
import ru.bjcreslin.domain.enumeration.ProcedureStatus;
import ru.bjcreslin.repository.ProcedureRepository;

/**
 * Integration tests for the {@link ProcedureResource} REST controller.
 */
@SpringBootTest(classes = VHelperApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class ProcedureResourceIT {
    private static final String DEFAULT_METHOD_FOR_DETERMINING_THE_SUPPLIER = "AAAAAAAAAA";
    private static final String UPDATED_METHOD_FOR_DETERMINING_THE_SUPPLIER = "BBBBBBBBBB";

    private static final String DEFAULT_PURCHASE_STAGE = "AAAAAAAAAA";
    private static final String UPDATED_PURCHASE_STAGE = "BBBBBBBBBB";

    private static final Long DEFAULT_NUMBER = 1L;
    private static final Long UPDATED_NUMBER = 2L;

    private static final String DEFAULT_ELECTRONIC_SITE = "AAAAAAAAAA";
    private static final String UPDATED_ELECTRONIC_SITE = "BBBBBBBBBB";

    private static final String DEFAULT_ELECTRONIC_AUCTION_SUBJECT = "AAAAAAAAAA";
    private static final String UPDATED_ELECTRONIC_AUCTION_SUBJECT = "BBBBBBBBBB";

    private static final String DEFAULT_TYPES_OF_WORK = "AAAAAAAAAA";
    private static final String UPDATED_TYPES_OF_WORK = "BBBBBBBBBB";

    private static final String DEFAULT_ORGANIZATION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATION_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE = "AAAAAAAAAA";
    private static final String UPDATED_PHONE = "BBBBBBBBBB";

    private static final String DEFAULT_CONTACT_PERSON = "AAAAAAAAAA";
    private static final String UPDATED_CONTACT_PERSON = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_DEADLINE_FOR_SUBMISSION = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_DEADLINE_FOR_SUBMISSION = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_DEADLINE_CONSIDERATION = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_DEADLINE_CONSIDERATION = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_DATE_OF_THE_ELECTRONIC_AUCTION = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_DATE_OF_THE_ELECTRONIC_AUCTION = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_TIME_OF_THE_ELECTRONIC_AUCTION = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_TIME_OF_THE_ELECTRONIC_AUCTION = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final BigDecimal DEFAULT_INITIAL_CONTRACT_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_INITIAL_CONTRACT_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_APPLICATION_SECURITY_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_APPLICATION_SECURITY_AMOUNT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_CONTRACT_SECURITY_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_CONTRACT_SECURITY_AMOUNT = new BigDecimal(2);

    private static final String DEFAULT_TURNAROUND_TIME = "AAAAAAAAAA";
    private static final String UPDATED_TURNAROUND_TIME = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_CREATED = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATED = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_EDITED = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_EDITED = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ProcedureStatus DEFAULT_STATUS = ProcedureStatus.NEW;
    private static final ProcedureStatus UPDATED_STATUS = ProcedureStatus.CLOSED;

    @Autowired
    private ProcedureRepository procedureRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restProcedureMockMvc;

    private Procedure procedure;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Procedure createEntity(EntityManager em) {
        Procedure procedure = new Procedure()
            .methodForDeterminingTheSupplier(DEFAULT_METHOD_FOR_DETERMINING_THE_SUPPLIER)
            .purchaseStage(DEFAULT_PURCHASE_STAGE)
            .number(DEFAULT_NUMBER)
            .electronicSite(DEFAULT_ELECTRONIC_SITE)
            .electronicAuctionSubject(DEFAULT_ELECTRONIC_AUCTION_SUBJECT)
            .typesOfWork(DEFAULT_TYPES_OF_WORK)
            .organizationName(DEFAULT_ORGANIZATION_NAME)
            .email(DEFAULT_EMAIL)
            .phone(DEFAULT_PHONE)
            .contactPerson(DEFAULT_CONTACT_PERSON)
            .deadlineForSubmission(DEFAULT_DEADLINE_FOR_SUBMISSION)
            .deadlineConsideration(DEFAULT_DEADLINE_CONSIDERATION)
            .dateOfTheElectronicAuction(DEFAULT_DATE_OF_THE_ELECTRONIC_AUCTION)
            .timeOfTheElectronicAuction(DEFAULT_TIME_OF_THE_ELECTRONIC_AUCTION)
            .initialContractPrice(DEFAULT_INITIAL_CONTRACT_PRICE)
            .applicationSecurityAmount(DEFAULT_APPLICATION_SECURITY_AMOUNT)
            .contractSecurityAmount(DEFAULT_CONTRACT_SECURITY_AMOUNT)
            .turnaroundTime(DEFAULT_TURNAROUND_TIME)
            .created(DEFAULT_CREATED)
            .edited(DEFAULT_EDITED)
            .status(DEFAULT_STATUS);
        return procedure;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Procedure createUpdatedEntity(EntityManager em) {
        Procedure procedure = new Procedure()
            .methodForDeterminingTheSupplier(UPDATED_METHOD_FOR_DETERMINING_THE_SUPPLIER)
            .purchaseStage(UPDATED_PURCHASE_STAGE)
            .number(UPDATED_NUMBER)
            .electronicSite(UPDATED_ELECTRONIC_SITE)
            .electronicAuctionSubject(UPDATED_ELECTRONIC_AUCTION_SUBJECT)
            .typesOfWork(UPDATED_TYPES_OF_WORK)
            .organizationName(UPDATED_ORGANIZATION_NAME)
            .email(UPDATED_EMAIL)
            .phone(UPDATED_PHONE)
            .contactPerson(UPDATED_CONTACT_PERSON)
            .deadlineForSubmission(UPDATED_DEADLINE_FOR_SUBMISSION)
            .deadlineConsideration(UPDATED_DEADLINE_CONSIDERATION)
            .dateOfTheElectronicAuction(UPDATED_DATE_OF_THE_ELECTRONIC_AUCTION)
            .timeOfTheElectronicAuction(UPDATED_TIME_OF_THE_ELECTRONIC_AUCTION)
            .initialContractPrice(UPDATED_INITIAL_CONTRACT_PRICE)
            .applicationSecurityAmount(UPDATED_APPLICATION_SECURITY_AMOUNT)
            .contractSecurityAmount(UPDATED_CONTRACT_SECURITY_AMOUNT)
            .turnaroundTime(UPDATED_TURNAROUND_TIME)
            .created(UPDATED_CREATED)
            .edited(UPDATED_EDITED)
            .status(UPDATED_STATUS);
        return procedure;
    }

    @BeforeEach
    public void initTest() {
        procedure = createEntity(em);
    }

    @Test
    @Transactional
    public void createProcedure() throws Exception {
        int databaseSizeBeforeCreate = procedureRepository.findAll().size();
        // Create the Procedure
        restProcedureMockMvc
            .perform(post("/api/procedures").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(procedure)))
            .andExpect(status().isCreated());

        // Validate the Procedure in the database
        List<Procedure> procedureList = procedureRepository.findAll();
        assertThat(procedureList).hasSize(databaseSizeBeforeCreate + 1);
        Procedure testProcedure = procedureList.get(procedureList.size() - 1);
        assertThat(testProcedure.getMethodForDeterminingTheSupplier()).isEqualTo(DEFAULT_METHOD_FOR_DETERMINING_THE_SUPPLIER);
        assertThat(testProcedure.getPurchaseStage()).isEqualTo(DEFAULT_PURCHASE_STAGE);
        assertThat(testProcedure.getNumber()).isEqualTo(DEFAULT_NUMBER);
        assertThat(testProcedure.getElectronicSite()).isEqualTo(DEFAULT_ELECTRONIC_SITE);
        assertThat(testProcedure.getElectronicAuctionSubject()).isEqualTo(DEFAULT_ELECTRONIC_AUCTION_SUBJECT);
        assertThat(testProcedure.getTypesOfWork()).isEqualTo(DEFAULT_TYPES_OF_WORK);
        assertThat(testProcedure.getOrganizationName()).isEqualTo(DEFAULT_ORGANIZATION_NAME);
        assertThat(testProcedure.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testProcedure.getPhone()).isEqualTo(DEFAULT_PHONE);
        assertThat(testProcedure.getContactPerson()).isEqualTo(DEFAULT_CONTACT_PERSON);
        assertThat(testProcedure.getDeadlineForSubmission()).isEqualTo(DEFAULT_DEADLINE_FOR_SUBMISSION);
        assertThat(testProcedure.getDeadlineConsideration()).isEqualTo(DEFAULT_DEADLINE_CONSIDERATION);
        assertThat(testProcedure.getDateOfTheElectronicAuction()).isEqualTo(DEFAULT_DATE_OF_THE_ELECTRONIC_AUCTION);
        assertThat(testProcedure.getTimeOfTheElectronicAuction()).isEqualTo(DEFAULT_TIME_OF_THE_ELECTRONIC_AUCTION);
        assertThat(testProcedure.getInitialContractPrice()).isEqualTo(DEFAULT_INITIAL_CONTRACT_PRICE);
        assertThat(testProcedure.getApplicationSecurityAmount()).isEqualTo(DEFAULT_APPLICATION_SECURITY_AMOUNT);
        assertThat(testProcedure.getContractSecurityAmount()).isEqualTo(DEFAULT_CONTRACT_SECURITY_AMOUNT);
        assertThat(testProcedure.getTurnaroundTime()).isEqualTo(DEFAULT_TURNAROUND_TIME);
        assertThat(testProcedure.getCreated()).isEqualTo(DEFAULT_CREATED);
        assertThat(testProcedure.getEdited()).isEqualTo(DEFAULT_EDITED);
        assertThat(testProcedure.getStatus()).isEqualTo(DEFAULT_STATUS);
    }

    @Test
    @Transactional
    public void createProcedureWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = procedureRepository.findAll().size();

        // Create the Procedure with an existing ID
        procedure.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restProcedureMockMvc
            .perform(post("/api/procedures").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(procedure)))
            .andExpect(status().isBadRequest());

        // Validate the Procedure in the database
        List<Procedure> procedureList = procedureRepository.findAll();
        assertThat(procedureList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllProcedures() throws Exception {
        // Initialize the database
        procedureRepository.saveAndFlush(procedure);

        // Get all the procedureList
        restProcedureMockMvc
            .perform(get("/api/procedures?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(procedure.getId().intValue())))
            .andExpect(jsonPath("$.[*].methodForDeterminingTheSupplier").value(hasItem(DEFAULT_METHOD_FOR_DETERMINING_THE_SUPPLIER)))
            .andExpect(jsonPath("$.[*].purchaseStage").value(hasItem(DEFAULT_PURCHASE_STAGE)))
            .andExpect(jsonPath("$.[*].number").value(hasItem(DEFAULT_NUMBER.intValue())))
            .andExpect(jsonPath("$.[*].electronicSite").value(hasItem(DEFAULT_ELECTRONIC_SITE)))
            .andExpect(jsonPath("$.[*].electronicAuctionSubject").value(hasItem(DEFAULT_ELECTRONIC_AUCTION_SUBJECT)))
            .andExpect(jsonPath("$.[*].typesOfWork").value(hasItem(DEFAULT_TYPES_OF_WORK)))
            .andExpect(jsonPath("$.[*].organizationName").value(hasItem(DEFAULT_ORGANIZATION_NAME)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].phone").value(hasItem(DEFAULT_PHONE)))
            .andExpect(jsonPath("$.[*].contactPerson").value(hasItem(DEFAULT_CONTACT_PERSON)))
            .andExpect(jsonPath("$.[*].deadlineForSubmission").value(hasItem(sameInstant(DEFAULT_DEADLINE_FOR_SUBMISSION))))
            .andExpect(jsonPath("$.[*].deadlineConsideration").value(hasItem(sameInstant(DEFAULT_DEADLINE_CONSIDERATION))))
            .andExpect(jsonPath("$.[*].dateOfTheElectronicAuction").value(hasItem(sameInstant(DEFAULT_DATE_OF_THE_ELECTRONIC_AUCTION))))
            .andExpect(jsonPath("$.[*].timeOfTheElectronicAuction").value(hasItem(sameInstant(DEFAULT_TIME_OF_THE_ELECTRONIC_AUCTION))))
            .andExpect(jsonPath("$.[*].initialContractPrice").value(hasItem(DEFAULT_INITIAL_CONTRACT_PRICE.intValue())))
            .andExpect(jsonPath("$.[*].applicationSecurityAmount").value(hasItem(DEFAULT_APPLICATION_SECURITY_AMOUNT.intValue())))
            .andExpect(jsonPath("$.[*].contractSecurityAmount").value(hasItem(DEFAULT_CONTRACT_SECURITY_AMOUNT.intValue())))
            .andExpect(jsonPath("$.[*].turnaroundTime").value(hasItem(DEFAULT_TURNAROUND_TIME)))
            .andExpect(jsonPath("$.[*].created").value(hasItem(sameInstant(DEFAULT_CREATED))))
            .andExpect(jsonPath("$.[*].edited").value(hasItem(sameInstant(DEFAULT_EDITED))))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())));
    }

    @Test
    @Transactional
    public void getProcedure() throws Exception {
        // Initialize the database
        procedureRepository.saveAndFlush(procedure);

        // Get the procedure
        restProcedureMockMvc
            .perform(get("/api/procedures/{id}", procedure.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(procedure.getId().intValue()))
            .andExpect(jsonPath("$.methodForDeterminingTheSupplier").value(DEFAULT_METHOD_FOR_DETERMINING_THE_SUPPLIER))
            .andExpect(jsonPath("$.purchaseStage").value(DEFAULT_PURCHASE_STAGE))
            .andExpect(jsonPath("$.number").value(DEFAULT_NUMBER.intValue()))
            .andExpect(jsonPath("$.electronicSite").value(DEFAULT_ELECTRONIC_SITE))
            .andExpect(jsonPath("$.electronicAuctionSubject").value(DEFAULT_ELECTRONIC_AUCTION_SUBJECT))
            .andExpect(jsonPath("$.typesOfWork").value(DEFAULT_TYPES_OF_WORK))
            .andExpect(jsonPath("$.organizationName").value(DEFAULT_ORGANIZATION_NAME))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.phone").value(DEFAULT_PHONE))
            .andExpect(jsonPath("$.contactPerson").value(DEFAULT_CONTACT_PERSON))
            .andExpect(jsonPath("$.deadlineForSubmission").value(sameInstant(DEFAULT_DEADLINE_FOR_SUBMISSION)))
            .andExpect(jsonPath("$.deadlineConsideration").value(sameInstant(DEFAULT_DEADLINE_CONSIDERATION)))
            .andExpect(jsonPath("$.dateOfTheElectronicAuction").value(sameInstant(DEFAULT_DATE_OF_THE_ELECTRONIC_AUCTION)))
            .andExpect(jsonPath("$.timeOfTheElectronicAuction").value(sameInstant(DEFAULT_TIME_OF_THE_ELECTRONIC_AUCTION)))
            .andExpect(jsonPath("$.initialContractPrice").value(DEFAULT_INITIAL_CONTRACT_PRICE.intValue()))
            .andExpect(jsonPath("$.applicationSecurityAmount").value(DEFAULT_APPLICATION_SECURITY_AMOUNT.intValue()))
            .andExpect(jsonPath("$.contractSecurityAmount").value(DEFAULT_CONTRACT_SECURITY_AMOUNT.intValue()))
            .andExpect(jsonPath("$.turnaroundTime").value(DEFAULT_TURNAROUND_TIME))
            .andExpect(jsonPath("$.created").value(sameInstant(DEFAULT_CREATED)))
            .andExpect(jsonPath("$.edited").value(sameInstant(DEFAULT_EDITED)))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingProcedure() throws Exception {
        // Get the procedure
        restProcedureMockMvc.perform(get("/api/procedures/{id}", Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateProcedure() throws Exception {
        // Initialize the database
        procedureRepository.saveAndFlush(procedure);

        int databaseSizeBeforeUpdate = procedureRepository.findAll().size();

        // Update the procedure
        Procedure updatedProcedure = procedureRepository.findById(procedure.getId()).get();
        // Disconnect from session so that the updates on updatedProcedure are not directly saved in db
        em.detach(updatedProcedure);
        updatedProcedure
            .methodForDeterminingTheSupplier(UPDATED_METHOD_FOR_DETERMINING_THE_SUPPLIER)
            .purchaseStage(UPDATED_PURCHASE_STAGE)
            .number(UPDATED_NUMBER)
            .electronicSite(UPDATED_ELECTRONIC_SITE)
            .electronicAuctionSubject(UPDATED_ELECTRONIC_AUCTION_SUBJECT)
            .typesOfWork(UPDATED_TYPES_OF_WORK)
            .organizationName(UPDATED_ORGANIZATION_NAME)
            .email(UPDATED_EMAIL)
            .phone(UPDATED_PHONE)
            .contactPerson(UPDATED_CONTACT_PERSON)
            .deadlineForSubmission(UPDATED_DEADLINE_FOR_SUBMISSION)
            .deadlineConsideration(UPDATED_DEADLINE_CONSIDERATION)
            .dateOfTheElectronicAuction(UPDATED_DATE_OF_THE_ELECTRONIC_AUCTION)
            .timeOfTheElectronicAuction(UPDATED_TIME_OF_THE_ELECTRONIC_AUCTION)
            .initialContractPrice(UPDATED_INITIAL_CONTRACT_PRICE)
            .applicationSecurityAmount(UPDATED_APPLICATION_SECURITY_AMOUNT)
            .contractSecurityAmount(UPDATED_CONTRACT_SECURITY_AMOUNT)
            .turnaroundTime(UPDATED_TURNAROUND_TIME)
            .created(UPDATED_CREATED)
            .edited(UPDATED_EDITED)
            .status(UPDATED_STATUS);

        restProcedureMockMvc
            .perform(
                put("/api/procedures").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(updatedProcedure))
            )
            .andExpect(status().isOk());

        // Validate the Procedure in the database
        List<Procedure> procedureList = procedureRepository.findAll();
        assertThat(procedureList).hasSize(databaseSizeBeforeUpdate);
        Procedure testProcedure = procedureList.get(procedureList.size() - 1);
        assertThat(testProcedure.getMethodForDeterminingTheSupplier()).isEqualTo(UPDATED_METHOD_FOR_DETERMINING_THE_SUPPLIER);
        assertThat(testProcedure.getPurchaseStage()).isEqualTo(UPDATED_PURCHASE_STAGE);
        assertThat(testProcedure.getNumber()).isEqualTo(UPDATED_NUMBER);
        assertThat(testProcedure.getElectronicSite()).isEqualTo(UPDATED_ELECTRONIC_SITE);
        assertThat(testProcedure.getElectronicAuctionSubject()).isEqualTo(UPDATED_ELECTRONIC_AUCTION_SUBJECT);
        assertThat(testProcedure.getTypesOfWork()).isEqualTo(UPDATED_TYPES_OF_WORK);
        assertThat(testProcedure.getOrganizationName()).isEqualTo(UPDATED_ORGANIZATION_NAME);
        assertThat(testProcedure.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testProcedure.getPhone()).isEqualTo(UPDATED_PHONE);
        assertThat(testProcedure.getContactPerson()).isEqualTo(UPDATED_CONTACT_PERSON);
        assertThat(testProcedure.getDeadlineForSubmission()).isEqualTo(UPDATED_DEADLINE_FOR_SUBMISSION);
        assertThat(testProcedure.getDeadlineConsideration()).isEqualTo(UPDATED_DEADLINE_CONSIDERATION);
        assertThat(testProcedure.getDateOfTheElectronicAuction()).isEqualTo(UPDATED_DATE_OF_THE_ELECTRONIC_AUCTION);
        assertThat(testProcedure.getTimeOfTheElectronicAuction()).isEqualTo(UPDATED_TIME_OF_THE_ELECTRONIC_AUCTION);
        assertThat(testProcedure.getInitialContractPrice()).isEqualTo(UPDATED_INITIAL_CONTRACT_PRICE);
        assertThat(testProcedure.getApplicationSecurityAmount()).isEqualTo(UPDATED_APPLICATION_SECURITY_AMOUNT);
        assertThat(testProcedure.getContractSecurityAmount()).isEqualTo(UPDATED_CONTRACT_SECURITY_AMOUNT);
        assertThat(testProcedure.getTurnaroundTime()).isEqualTo(UPDATED_TURNAROUND_TIME);
        assertThat(testProcedure.getCreated()).isEqualTo(UPDATED_CREATED);
        assertThat(testProcedure.getEdited()).isEqualTo(UPDATED_EDITED);
        assertThat(testProcedure.getStatus()).isEqualTo(UPDATED_STATUS);
    }

    @Test
    @Transactional
    public void updateNonExistingProcedure() throws Exception {
        int databaseSizeBeforeUpdate = procedureRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restProcedureMockMvc
            .perform(put("/api/procedures").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(procedure)))
            .andExpect(status().isBadRequest());

        // Validate the Procedure in the database
        List<Procedure> procedureList = procedureRepository.findAll();
        assertThat(procedureList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteProcedure() throws Exception {
        // Initialize the database
        procedureRepository.saveAndFlush(procedure);

        int databaseSizeBeforeDelete = procedureRepository.findAll().size();

        // Delete the procedure
        restProcedureMockMvc
            .perform(delete("/api/procedures/{id}", procedure.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Procedure> procedureList = procedureRepository.findAll();
        assertThat(procedureList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
