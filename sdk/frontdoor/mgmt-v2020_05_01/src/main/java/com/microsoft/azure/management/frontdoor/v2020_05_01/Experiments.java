/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.frontdoor.v2020_05_01;

import com.microsoft.azure.arm.collection.SupportsCreating;
import rx.Completable;
import rx.Observable;
import com.microsoft.azure.management.frontdoor.v2020_05_01.implementation.ExperimentsInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing Experiments.
 */
public interface Experiments extends SupportsCreating<Experiment.DefinitionStages.Blank>, HasInner<ExperimentsInner> {
    /**
     * Gets an Experiment by ExperimentName.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName The Profile identifier associated with the Tenant and Partner
     * @param experimentName The Experiment identifier associated with the Experiment
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<Experiment> getAsync(String resourceGroupName, String profileName, String experimentName);

    /**
     * Gets a list of Experiments.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName The Profile identifier associated with the Tenant and Partner
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<Experiment> listByProfileAsync(final String resourceGroupName, final String profileName);

    /**
     * Deletes an Experiment.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param profileName The Profile identifier associated with the Tenant and Partner
     * @param experimentName The Experiment identifier associated with the Experiment
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable deleteAsync(String resourceGroupName, String profileName, String experimentName);

}
