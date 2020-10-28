import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './procedure.reducer';
import { IProcedure } from 'app/shared/model/procedure.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IProcedureUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const ProcedureUpdate = (props: IProcedureUpdateProps) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { procedureEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/procedure');
  };

  useEffect(() => {
    if (isNew) {
      props.reset();
    } else {
      props.getEntity(props.match.params.id);
    }
  }, []);

  useEffect(() => {
    if (props.updateSuccess) {
      handleClose();
    }
  }, [props.updateSuccess]);

  const saveEntity = (event, errors, values) => {
    values.deadlineForSubmission = convertDateTimeToServer(values.deadlineForSubmission);
    values.deadlineConsideration = convertDateTimeToServer(values.deadlineConsideration);
    values.dateOfTheElectronicAuction = convertDateTimeToServer(values.dateOfTheElectronicAuction);
    values.timeOfTheElectronicAuction = convertDateTimeToServer(values.timeOfTheElectronicAuction);
    values.created = convertDateTimeToServer(values.created);
    values.edited = convertDateTimeToServer(values.edited);

    if (errors.length === 0) {
      const entity = {
        ...procedureEntity,
        ...values,
      };

      if (isNew) {
        props.createEntity(entity);
      } else {
        props.updateEntity(entity);
      }
    }
  };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="vHelperApp.procedure.home.createOrEditLabel">
            <Translate contentKey="vHelperApp.procedure.home.createOrEditLabel">Create or edit a Procedure</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : procedureEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="procedure-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="procedure-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="methodForDeterminingTheSupplierLabel" for="procedure-methodForDeterminingTheSupplier">
                  <Translate contentKey="vHelperApp.procedure.methodForDeterminingTheSupplier">
                    Method For Determining The Supplier
                  </Translate>
                </Label>
                <AvField id="procedure-methodForDeterminingTheSupplier" type="text" name="methodForDeterminingTheSupplier" />
              </AvGroup>
              <AvGroup>
                <Label id="purchaseStageLabel" for="procedure-purchaseStage">
                  <Translate contentKey="vHelperApp.procedure.purchaseStage">Purchase Stage</Translate>
                </Label>
                <AvField id="procedure-purchaseStage" type="text" name="purchaseStage" />
              </AvGroup>
              <AvGroup>
                <Label id="numberLabel" for="procedure-number">
                  <Translate contentKey="vHelperApp.procedure.number">Number</Translate>
                </Label>
                <AvField id="procedure-number" type="string" className="form-control" name="number" />
              </AvGroup>
              <AvGroup>
                <Label id="electronicSiteLabel" for="procedure-electronicSite">
                  <Translate contentKey="vHelperApp.procedure.electronicSite">Electronic Site</Translate>
                </Label>
                <AvField id="procedure-electronicSite" type="text" name="electronicSite" />
              </AvGroup>
              <AvGroup>
                <Label id="electronicAuctionSubjectLabel" for="procedure-electronicAuctionSubject">
                  <Translate contentKey="vHelperApp.procedure.electronicAuctionSubject">Electronic Auction Subject</Translate>
                </Label>
                <AvField id="procedure-electronicAuctionSubject" type="text" name="electronicAuctionSubject" />
              </AvGroup>
              <AvGroup>
                <Label id="typesOfWorkLabel" for="procedure-typesOfWork">
                  <Translate contentKey="vHelperApp.procedure.typesOfWork">Types Of Work</Translate>
                </Label>
                <AvField id="procedure-typesOfWork" type="text" name="typesOfWork" />
              </AvGroup>
              <AvGroup>
                <Label id="organizationNameLabel" for="procedure-organizationName">
                  <Translate contentKey="vHelperApp.procedure.organizationName">Organization Name</Translate>
                </Label>
                <AvField id="procedure-organizationName" type="text" name="organizationName" />
              </AvGroup>
              <AvGroup>
                <Label id="emailLabel" for="procedure-email">
                  <Translate contentKey="vHelperApp.procedure.email">Email</Translate>
                </Label>
                <AvField id="procedure-email" type="text" name="email" />
              </AvGroup>
              <AvGroup>
                <Label id="phoneLabel" for="procedure-phone">
                  <Translate contentKey="vHelperApp.procedure.phone">Phone</Translate>
                </Label>
                <AvField id="procedure-phone" type="text" name="phone" />
              </AvGroup>
              <AvGroup>
                <Label id="contactPersonLabel" for="procedure-contactPerson">
                  <Translate contentKey="vHelperApp.procedure.contactPerson">Contact Person</Translate>
                </Label>
                <AvField id="procedure-contactPerson" type="text" name="contactPerson" />
              </AvGroup>
              <AvGroup>
                <Label id="deadlineForSubmissionLabel" for="procedure-deadlineForSubmission">
                  <Translate contentKey="vHelperApp.procedure.deadlineForSubmission">Deadline For Submission</Translate>
                </Label>
                <AvInput
                  id="procedure-deadlineForSubmission"
                  type="datetime-local"
                  className="form-control"
                  name="deadlineForSubmission"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.procedureEntity.deadlineForSubmission)}
                />
              </AvGroup>
              <AvGroup>
                <Label id="deadlineConsiderationLabel" for="procedure-deadlineConsideration">
                  <Translate contentKey="vHelperApp.procedure.deadlineConsideration">Deadline Consideration</Translate>
                </Label>
                <AvInput
                  id="procedure-deadlineConsideration"
                  type="datetime-local"
                  className="form-control"
                  name="deadlineConsideration"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.procedureEntity.deadlineConsideration)}
                />
              </AvGroup>
              <AvGroup>
                <Label id="dateOfTheElectronicAuctionLabel" for="procedure-dateOfTheElectronicAuction">
                  <Translate contentKey="vHelperApp.procedure.dateOfTheElectronicAuction">Date Of The Electronic Auction</Translate>
                </Label>
                <AvInput
                  id="procedure-dateOfTheElectronicAuction"
                  type="datetime-local"
                  className="form-control"
                  name="dateOfTheElectronicAuction"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.procedureEntity.dateOfTheElectronicAuction)}
                />
              </AvGroup>
              <AvGroup>
                <Label id="timeOfTheElectronicAuctionLabel" for="procedure-timeOfTheElectronicAuction">
                  <Translate contentKey="vHelperApp.procedure.timeOfTheElectronicAuction">Time Of The Electronic Auction</Translate>
                </Label>
                <AvInput
                  id="procedure-timeOfTheElectronicAuction"
                  type="datetime-local"
                  className="form-control"
                  name="timeOfTheElectronicAuction"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.procedureEntity.timeOfTheElectronicAuction)}
                />
              </AvGroup>
              <AvGroup>
                <Label id="initialContractPriceLabel" for="procedure-initialContractPrice">
                  <Translate contentKey="vHelperApp.procedure.initialContractPrice">Initial Contract Price</Translate>
                </Label>
                <AvField id="procedure-initialContractPrice" type="text" name="initialContractPrice" />
              </AvGroup>
              <AvGroup>
                <Label id="applicationSecurityAmountLabel" for="procedure-applicationSecurityAmount">
                  <Translate contentKey="vHelperApp.procedure.applicationSecurityAmount">Application Security Amount</Translate>
                </Label>
                <AvField id="procedure-applicationSecurityAmount" type="text" name="applicationSecurityAmount" />
              </AvGroup>
              <AvGroup>
                <Label id="contractSecurityAmountLabel" for="procedure-contractSecurityAmount">
                  <Translate contentKey="vHelperApp.procedure.contractSecurityAmount">Contract Security Amount</Translate>
                </Label>
                <AvField id="procedure-contractSecurityAmount" type="text" name="contractSecurityAmount" />
              </AvGroup>
              <AvGroup>
                <Label id="turnaroundTimeLabel" for="procedure-turnaroundTime">
                  <Translate contentKey="vHelperApp.procedure.turnaroundTime">Turnaround Time</Translate>
                </Label>
                <AvField id="procedure-turnaroundTime" type="text" name="turnaroundTime" />
              </AvGroup>
              <AvGroup>
                <Label id="createdLabel" for="procedure-created">
                  <Translate contentKey="vHelperApp.procedure.created">Created</Translate>
                </Label>
                <AvInput
                  id="procedure-created"
                  type="datetime-local"
                  className="form-control"
                  name="created"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.procedureEntity.created)}
                />
              </AvGroup>
              <AvGroup>
                <Label id="editedLabel" for="procedure-edited">
                  <Translate contentKey="vHelperApp.procedure.edited">Edited</Translate>
                </Label>
                <AvInput
                  id="procedure-edited"
                  type="datetime-local"
                  className="form-control"
                  name="edited"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.procedureEntity.edited)}
                />
              </AvGroup>
              <AvGroup>
                <Label id="statusLabel" for="procedure-status">
                  <Translate contentKey="vHelperApp.procedure.status">Status</Translate>
                </Label>
                <AvInput
                  id="procedure-status"
                  type="select"
                  className="form-control"
                  name="status"
                  value={(!isNew && procedureEntity.status) || 'NEW'}
                >
                  <option value="NEW">{translate('vHelperApp.ProcedureStatus.NEW')}</option>
                  <option value="CLOSED">{translate('vHelperApp.ProcedureStatus.CLOSED')}</option>
                  <option value="ENDED">{translate('vHelperApp.ProcedureStatus.ENDED')}</option>
                  <option value="ACTIVE">{translate('vHelperApp.ProcedureStatus.ACTIVE')}</option>
                  <option value="DELETED">{translate('vHelperApp.ProcedureStatus.DELETED')}</option>
                  <option value="STOPED">{translate('vHelperApp.ProcedureStatus.STOPED')}</option>
                </AvInput>
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/procedure" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </AvForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

const mapStateToProps = (storeState: IRootState) => ({
  procedureEntity: storeState.procedure.entity,
  loading: storeState.procedure.loading,
  updating: storeState.procedure.updating,
  updateSuccess: storeState.procedure.updateSuccess,
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset,
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(ProcedureUpdate);
