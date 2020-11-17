import React from 'react';
import {NavDropdown} from "app/shared/layout/menus/menu-components";
import {Translate, translate} from "react-jhipster";
import MenuItem from "app/shared/layout/menus/menu-item";
export const Zakupkimenu = props => (
  <NavDropdown
    icon="th-list"
name={translate('global.menu.entities.main')}
id="entity-menu"
style={{ maxHeight: '80vh', overflow: 'auto' }}
>
<MenuItem icon="asterisk" to="/procedure">
<Translate contentKey="global.menu.entities.procedure" />
  </MenuItem>
{/* jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here */}
</NavDropdown>
);
