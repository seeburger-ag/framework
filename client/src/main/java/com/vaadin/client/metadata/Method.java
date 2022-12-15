/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.metadata;

import com.vaadin.shared.annotations.NoLayout;

public class Method {

    private final Type type;
    private final String name;

    public Method(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Type getReturnType() throws NoDataException {
        return TypeDataStore.getReturnType(this);
    }

    public void invoke(Object target, Object... params) throws NoDataException {
        TypeDataStore.getInvoker(this).invoke(target, params);
    }

    /**
     * The unique signature used to identify this method. The structure of the
     * returned string may change without notice and should not be used for any
     * other purpose than identification. The signature is currently based on
     * the declaring type's signature and the method's name.
     *
     * @return the unique signature of this method
     */
    public String getSignature() {
        return type.getSignature() + "." + name;
    }

    /**
     * Gets the string that is internally used when looking up generated support
     * code for this method. This is the same as {@link #getSignature()}, but
     * without any type parameters.
     *
     * @return the string to use for looking up generated support code
     *
     * @since 7.2
     */
    public String getLookupKey() {
        return type.getBaseTypeName() + "." + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof Method) {
            Method other = (Method) obj;
            return other.getSignature().equals(getSignature());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return getSignature();
    }

    @Override
    public int hashCode() {
        return getSignature().hashCode();
    }

    public Type[] getParameterTypes() throws NoDataException {
        return TypeDataStore.getParamTypes(this);
    }

    public boolean isDelayed() {
        return TypeDataStore.isDelayed(this);
    }

    public boolean isLastOnly() {
        return TypeDataStore.isLastOnly(this);
    }

    /**
     * Checks whether this method is annotated with {@link NoLayout}.
     *
     * @since 7.4
     *
     * @return <code>true</code> if this method has a NoLayout annotation;
     *         otherwise <code>false</code>
     */
    public boolean isNoLayout() {
        return TypeDataStore.isNoLayoutRpcMethod(this);
    }

}
