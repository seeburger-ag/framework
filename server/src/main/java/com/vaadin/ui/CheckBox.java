/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.ui;

import java.util.Collection;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

import com.vaadin.data.Property;
import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.event.FieldEvents.FocusAndBlurServerRpcImpl;
import com.vaadin.event.FieldEvents.FocusEvent;
import com.vaadin.event.FieldEvents.FocusListener;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.ui.checkbox.CheckBoxServerRpc;
import com.vaadin.shared.ui.checkbox.CheckBoxState;
import com.vaadin.ui.declarative.DesignAttributeHandler;
import com.vaadin.ui.declarative.DesignContext;

public class CheckBox extends AbstractField<Boolean> {

    private CheckBoxServerRpc rpc = new CheckBoxServerRpc() {

        @Override
        public void setChecked(boolean checked,
                MouseEventDetails mouseEventDetails) {
            if (isReadOnly()) {
                return;
            }

            /*
             * Client side updates the state before sending the event so we need
             * to make sure the cached state is updated to match the client. If
             * we do not do this, a reverting setValue() call in a listener will
             * not cause the new state to be sent to the client.
             *
             * See #11028, #10030.
             */
            getUI().getConnectorTracker().getDiffState(CheckBox.this)
                    .put("checked", checked);

            final Boolean oldValue = getValue();
            final Boolean newValue = checked;

            if (!newValue.equals(oldValue)) {
                // The event is only sent if the switch state is changed
                setValue(newValue);
            }

        }
    };

    FocusAndBlurServerRpcImpl focusBlurRpc = new FocusAndBlurServerRpcImpl(
            this) {
        @Override
        protected void fireEvent(Event event) {
            CheckBox.this.fireEvent(event);
        }
    };

    /**
     * Creates a new checkbox.
     */
    public CheckBox() {
        registerRpc(rpc);
        registerRpc(focusBlurRpc);
        setValue(Boolean.FALSE);
    }

    /**
     * Creates a new checkbox with a set caption.
     *
     * @param caption
     *            the Checkbox caption.
     */
    public CheckBox(String caption) {
        this();
        setCaption(caption);
    }

    /**
     * Creates a new checkbox with a caption and a set initial state.
     *
     * @param caption
     *            the caption of the checkbox
     * @param initialState
     *            the initial state of the checkbox
     */
    public CheckBox(String caption, boolean initialState) {
        this(caption);
        setValue(initialState);
    }

    /**
     * Creates a new checkbox that is connected to a boolean property.
     *
     * @param state
     *            the Initial state of the switch-button.
     * @param dataSource
     */
    public CheckBox(String caption, Property<?> dataSource) {
        this(caption);
        setPropertyDataSource(dataSource);
    }

    @Override
    public Class<Boolean> getType() {
        return Boolean.class;
    }

    @Override
    protected CheckBoxState getState() {
        return (CheckBoxState) super.getState();
    }

    /*
     * Overridden to keep the shared state in sync with the AbstractField
     * internal value. Should be removed once AbstractField is refactored to use
     * shared state.
     *
     * See tickets #10921 and #11064.
     */
    @Override
    protected void setInternalValue(Boolean newValue) {
        super.setInternalValue(newValue);
        if (newValue == null) {
            newValue = false;
        }
        getState().checked = newValue;
    }

    public void addBlurListener(BlurListener listener) {
        addListener(BlurEvent.EVENT_ID, BlurEvent.class, listener,
                BlurListener.blurMethod);
    }

    /**
     * @deprecated As of 7.0, replaced by {@link #addBlurListener(BlurListener)}
     **/
    @Deprecated
    public void addListener(BlurListener listener) {
        addBlurListener(listener);
    }

    public void removeBlurListener(BlurListener listener) {
        removeListener(BlurEvent.EVENT_ID, BlurEvent.class, listener);
    }

    /**
     * @deprecated As of 7.0, replaced by
     *             {@link #removeBlurListener(BlurListener)}
     **/
    @Deprecated
    public void removeListener(BlurListener listener) {
        removeBlurListener(listener);
    }

    public void addFocusListener(FocusListener listener) {
        addListener(FocusEvent.EVENT_ID, FocusEvent.class, listener,
                FocusListener.focusMethod);
    }

    /**
     * @deprecated As of 7.0, replaced by
     *             {@link #addFocusListener(FocusListener)}
     **/
    @Deprecated
    public void addListener(FocusListener listener) {
        addFocusListener(listener);
    }

    public void removeFocusListener(FocusListener listener) {
        removeListener(FocusEvent.EVENT_ID, FocusEvent.class, listener);
    }

    /**
     * @deprecated As of 7.0, replaced by
     *             {@link #removeFocusListener(FocusListener)}
     **/
    @Deprecated
    public void removeListener(FocusListener listener) {
        removeFocusListener(listener);
    }

    /**
     * Get the boolean value of the button state.
     *
     * @return True iff the button is pressed down or checked.
     *
     * @deprecated As of 7.0, use {@link #getValue()} instead and, if needed,
     *             handle null values.
     */
    @Deprecated
    public boolean booleanValue() {
        Boolean value = getValue();
        return (null == value) ? false : value.booleanValue();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.ui.AbstractField#readDesign(org.jsoup.nodes.Element,
     * com.vaadin.ui.declarative.DesignContext)
     */
    @Override
    public void readDesign(Element design, DesignContext designContext) {
        super.readDesign(design, designContext);
        if (design.hasAttr("checked")) {
            this.setValue(DesignAttributeHandler.readAttribute("checked",
                    design.attributes(), Boolean.class), false, true);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.ui.AbstractField#getCustomAttributes()
     */
    @Override
    protected Collection<String> getCustomAttributes() {
        Collection<String> attributes = super.getCustomAttributes();
        attributes.add("checked");
        return attributes;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.ui.AbstractField#writeDesign(org.jsoup.nodes.Element,
     * com.vaadin.ui.declarative.DesignContext)
     */
    @Override
    public void writeDesign(Element design, DesignContext designContext) {
        super.writeDesign(design, designContext);
        CheckBox def = (CheckBox) designContext.getDefaultInstance(this);
        Attributes attr = design.attributes();
        DesignAttributeHandler.writeAttribute("checked", attr, getValue(),
                def.getValue(), Boolean.class);
    }

    @Override
    public void clear() {
        setValue(Boolean.FALSE);
    }

    @Override
    public boolean isEmpty() {
        return getValue() == null || getValue().equals(Boolean.FALSE);

    }

}
