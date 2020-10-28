import { Moment } from 'moment';
import { ProcedureStatus } from 'app/shared/model/enumerations/procedure-status.model';

export interface IProcedure {
  id?: number;
  methodForDeterminingTheSupplier?: string;
  purchaseStage?: string;
  number?: number;
  electronicSite?: string;
  electronicAuctionSubject?: string;
  typesOfWork?: string;
  organizationName?: string;
  email?: string;
  phone?: string;
  contactPerson?: string;
  deadlineForSubmission?: string;
  deadlineConsideration?: string;
  dateOfTheElectronicAuction?: string;
  timeOfTheElectronicAuction?: string;
  initialContractPrice?: number;
  applicationSecurityAmount?: number;
  contractSecurityAmount?: number;
  turnaroundTime?: string;
  created?: string;
  edited?: string;
  status?: ProcedureStatus;
}

export const defaultValue: Readonly<IProcedure> = {};
