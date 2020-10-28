import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './procedure.reducer';
import { IProcedure } from 'app/shared/model/procedure.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IProcedureProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const Procedure = (props: IProcedureProps) => {
  useEffect(() => {
    props.getEntities();
  }, []);

  const { procedureList, match, loading } = props;
  return (
    <div>
      <h2 id="procedure-heading">
        <Translate contentKey="vHelperApp.procedure.home.title">Procedures</Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="vHelperApp.procedure.home.createLabel">Create new Procedure</Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        {procedureList && procedureList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="global.field.id">ID</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.methodForDeterminingTheSupplier">
                    Method For Determining The Supplier
                  </Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.purchaseStage">Purchase Stage</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.number">Number</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.electronicSite">Electronic Site</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.electronicAuctionSubject">Electronic Auction Subject</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.typesOfWork">Types Of Work</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.organizationName">Organization Name</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.email">Email</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.phone">Phone</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.contactPerson">Contact Person</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.deadlineForSubmission">Deadline For Submission</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.deadlineConsideration">Deadline Consideration</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.dateOfTheElectronicAuction">Date Of The Electronic Auction</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.timeOfTheElectronicAuction">Time Of The Electronic Auction</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.initialContractPrice">Initial Contract Price</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.applicationSecurityAmount">Application Security Amount</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.contractSecurityAmount">Contract Security Amount</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.turnaroundTime">Turnaround Time</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.created">Created</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.edited">Edited</Translate>
                </th>
                <th>
                  <Translate contentKey="vHelperApp.procedure.status">Status</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {procedureList.map((procedure, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${procedure.id}`} color="link" size="sm">
                      {procedure.id}
                    </Button>
                  </td>
                  <td>{procedure.methodForDeterminingTheSupplier}</td>
                  <td>{procedure.purchaseStage}</td>
                  <td>{procedure.number}</td>
                  <td>{procedure.electronicSite}</td>
                  <td>{procedure.electronicAuctionSubject}</td>
                  <td>{procedure.typesOfWork}</td>
                  <td>{procedure.organizationName}</td>
                  <td>{procedure.email}</td>
                  <td>{procedure.phone}</td>
                  <td>{procedure.contactPerson}</td>
                  <td>
                    {procedure.deadlineForSubmission ? (
                      <TextFormat type="date" value={procedure.deadlineForSubmission} format={APP_DATE_FORMAT} />
                    ) : null}
                  </td>
                  <td>
                    {procedure.deadlineConsideration ? (
                      <TextFormat type="date" value={procedure.deadlineConsideration} format={APP_DATE_FORMAT} />
                    ) : null}
                  </td>
                  <td>
                    {procedure.dateOfTheElectronicAuction ? (
                      <TextFormat type="date" value={procedure.dateOfTheElectronicAuction} format={APP_DATE_FORMAT} />
                    ) : null}
                  </td>
                  <td>
                    {procedure.timeOfTheElectronicAuction ? (
                      <TextFormat type="date" value={procedure.timeOfTheElectronicAuction} format={APP_DATE_FORMAT} />
                    ) : null}
                  </td>
                  <td>{procedure.initialContractPrice}</td>
                  <td>{procedure.applicationSecurityAmount}</td>
                  <td>{procedure.contractSecurityAmount}</td>
                  <td>{procedure.turnaroundTime}</td>
                  <td>{procedure.created ? <TextFormat type="date" value={procedure.created} format={APP_DATE_FORMAT} /> : null}</td>
                  <td>{procedure.edited ? <TextFormat type="date" value={procedure.edited} format={APP_DATE_FORMAT} /> : null}</td>
                  <td>
                    <Translate contentKey={`vHelperApp.ProcedureStatus.${procedure.status}`} />
                  </td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${procedure.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${procedure.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${procedure.id}/delete`} color="danger" size="sm">
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && (
            <div className="alert alert-warning">
              <Translate contentKey="vHelperApp.procedure.home.notFound">No Procedures found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

const mapStateToProps = ({ procedure }: IRootState) => ({
  procedureList: procedure.entities,
  loading: procedure.loading,
});

const mapDispatchToProps = {
  getEntities,
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(Procedure);
