// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006 Talend - www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.repository.ui.properties;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.Property;

/**
 * DOC mhelleboid class global comment. Detailled comment <br/>
 * 
 * $Id$
 * 
 */
public class DateSection extends AbstractSection {

    private Text creationDate;

    private Text modificationDate;

    private Text commitDate;

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat();

    @Override
    protected void enableControl(boolean enable) {
    }

    @Override
    protected void showControl(boolean visible) {
        creationDate.getParent().setVisible(visible);
    }

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);

        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        FormData data;

        creationDate = getWidgetFactory().createText(composite, ""); //$NON-NLS-1$
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(33, 0);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        creationDate.setLayoutData(data);
        creationDate.setEnabled(false);

        CLabel creationLabel = getWidgetFactory().createCLabel(composite, "Creation");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(creationDate, -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(creationDate, 0, SWT.CENTER);
        creationLabel.setLayoutData(data);

        modificationDate = getWidgetFactory().createText(composite, ""); //$NON-NLS-1$
        data = new FormData();
        data.left = new FormAttachment(creationDate, STANDARD_LABEL_WIDTH + 15);
        data.right = new FormAttachment(66, 0);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        modificationDate.setLayoutData(data);
        modificationDate.setEnabled(false);

        CLabel modificationLabel = getWidgetFactory().createCLabel(composite, "Modification");
        data = new FormData();
        data.left = new FormAttachment(creationDate, ITabbedPropertyConstants.HSPACE * 3);
        data.right = new FormAttachment(modificationDate, -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(modificationDate, 0, SWT.CENTER);
        modificationLabel.setLayoutData(data);

        if (getCommitDate() != null) {
            commitDate = getWidgetFactory().createText(composite, ""); //$NON-NLS-1$
            data = new FormData();
            data.left = new FormAttachment(modificationDate, STANDARD_LABEL_WIDTH + 15);
            data.right = new FormAttachment(100, 0);
            data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
            commitDate.setLayoutData(data);
            commitDate.setEnabled(false);

            CLabel commitLabel = getWidgetFactory().createCLabel(composite, "Commit");
            data = new FormData();
            data.left = new FormAttachment(modificationDate, ITabbedPropertyConstants.HSPACE * 3);
            data.right = new FormAttachment(commitDate, -ITabbedPropertyConstants.HSPACE);
            data.top = new FormAttachment(commitDate, 0, SWT.CENTER);
            commitLabel.setLayoutData(data);
        }

        addFocusListenerToChildren(composite);
    }

    @Override
    public void refresh() {
        creationDate.setText(getCreationDate() != null ? FORMATTER.format(getCreationDate()) : "");
        modificationDate.setText(getModificationDate() != null ? FORMATTER.format(getModificationDate()) : "");
        commitDate.setText(getCommitDate() != null ? FORMATTER.format(getCommitDate()) : "");
    }

    protected Date getCreationDate() {
        return getObject().getCreationDate();
    }

    protected Date getModificationDate() {
        return getObject().getModificationDate();
    }

    protected Date getCommitDate() {
        Property property = getObject().getProperty();
        if (property == null) {
            return null;
        }

        Item item = property.getItem();
        ItemState state = item.getState();

        return state.getCommitDate();
    }

    protected void beforeSave() {
    }

}
