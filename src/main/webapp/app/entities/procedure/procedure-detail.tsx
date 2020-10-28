import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './procedure.reducer';
import { IProcedure } from 'app/shared/model/procedure.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IProcedureDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const ProcedureDetail = (props: IProcedureDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { procedureEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="vHelperApp.procedure.detail.title">Procedure</Translate> [<b>{procedureEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="methodForDeterminingTheSupplier">
              <Translate contentKey="vHelperApp.procedure.methodForDeterminingTheSupplier">Method For Determining The Supplier</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.methodForDeterminingTheSupplier}</dd>
          <dt>
            <span id="purchaseStage">
              <Translate contentKey="vHelperApp.procedure.purchaseStage">Purchase Stage</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.purchaseStage}</dd>
          <dt>
            <span id="number">
              <Translate contentKey="vHelperApp.procedure.number">Number</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.number}</dd>
          <dt>
            <span id="electronicSite">
              <Translate contentKey="vHelperApp.procedure.electronicSite">Electronic Site</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.electronicSite}</dd>
          <dt>
            <span id="electronicAuctionSubject">
              <Translate contentKey="vHelperApp.procedure.electronicAuctionSubject">Electronic Auction Subject</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.electronicAuctionSubject}</dd>
          <dt>
            <span id="typesOfWork">
              <Translate contentKey="vHelperApp.procedure.typesOfWork">Types Of Work</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.typesOfWork}</dd>
          <dt>
            <span id="organizationName">
              <Translate contentKey="vHelperApp.procedure.organizationName">Organization Name</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.organizationName}</dd>
          <dt>
            <span id="email">
              <Translate contentKey="vHelperApp.procedure.email">Email</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.email}</dd>
          <dt>
            <span id="phone">
              <Translate contentKey="vHelperApp.procedure.phone">Phone</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.phone}</dd>
          <dt>
            <span id="contactPerson">
              <Translate contentKey="vHelperApp.procedure.contactPerson">Contact Person</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.contactPerson}</dd>
          <dt>
            <span id="deadlineForSubmission">
              <Translate contentKey="vHelperApp.procedure.deadlineForSubmission">Deadline For Submission</Translate>
            </span>
          </dt>
          <dd>
            {procedureEntity.deadlineForSubmission ? (
              <TextFormat value={procedureEntity.deadlineForSubmission} type="date" format={APP_DATE_FORMAT} />
            ) : null}
          </dd>
          <dt>
            <span id="deadlineConsideration">
              <Translate contentKey="vHelperApp.procedure.deadlineConsideration">Deadline Consideration</Translate>
            </span>
          </dt>
          <dd>
            {procedureEntity.deadlineConsideration ? (
              <TextFormat value={procedureEntity.deadlineConsideration} type="date" format={APP_DATE_FORMAT} />
            ) : null}
          </dd>
          <dt>
            <span id="dateOfTheElectronicAuction">
              <Translate contentKey="vHelperApp.procedure.dateOfTheElectronicAuction">Date Of The Electronic Auction</Translate>
            </span>
          </dt>
          <dd>
            {procedureEntity.dateOfTheElectronicAuction ? (
              <TextFormat value={procedureEntity.dateOfTheElectronicAuction} type="date" format={APP_DATE_FORMAT} />
            ) : null}
          </dd>
          <dt>
            <span id="timeOfTheElectronicAuction">
              <Translate contentKey="vHelperApp.procedure.timeOfTheElectronicAuction">Time Of The Electronic Auction</Translate>
            </span>
          </dt>
          <dd>
            {procedureEntity.timeOfTheElectronicAuction ? (
              <TextFormat value={procedureEntity.timeOfTheElectronicAuction} type="date" format={APP_DATE_FORMAT} />
            ) : null}
          </dd>
          <dt>
            <span id="initialContractPrice">
              <Translate contentKey="vHelperApp.procedure.initialContractPrice">Initial Contract Price</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.initialContractPrice}</dd>
          <dt>
            <span id="applicationSecurityAmount">
              <Translate contentKey="vHelperApp.procedure.applicationSecurityAmount">Application Security Amount</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.applicationSecurityAmount}</dd>
          <dt>
            <span id="contractSecurityAmount">
              <Translate contentKey="vHelperApp.procedure.contractSecurityAmount">Contract Security Amount</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.contractSecurityAmount}</dd>
          <dt>
            <span id="turnaroundTime">
              <Translate contentKey="vHelperApp.procedure.turnaroundTime">Turnaround Time</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.turnaroundTime}</dd>
          <dt>
            <span id="created">
              <Translate contentKey="vHelperApp.procedure.created">Created</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.created ? <TextFormat value={procedureEntity.created} type="date" format={APP_DATE_FORMAT} /> : null}</dd>
          <dt>
            <span id="edited">
              <Translate contentKey="vHelperApp.procedure.edited">Edited</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.edited ? <TextFormat value={procedureEntity.edited} type="date" format={APP_DATE_FORMAT} /> : null}</dd>
          <dt>
            <span id="status">
              <Translate contentKey="vHelperApp.procedure.status">Status</Translate>
            </span>
          </dt>
          <dd>{procedureEntity.status}</dd>
        </dl>
        <Button tag={Link} to="/procedure" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/procedure/${procedureEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ procedure }: IRootState) => ({
  procedureEntity: procedure.entity,
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(ProcedureDetail);
