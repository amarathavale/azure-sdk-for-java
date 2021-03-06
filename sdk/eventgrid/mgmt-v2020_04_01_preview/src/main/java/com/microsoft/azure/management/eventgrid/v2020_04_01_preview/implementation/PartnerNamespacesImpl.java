/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * def
 */

package com.microsoft.azure.management.eventgrid.v2020_04_01_preview.implementation;

import com.microsoft.azure.arm.resources.collection.implementation.GroupableResourcesCoreImpl;
import com.microsoft.azure.management.eventgrid.v2020_04_01_preview.PartnerNamespaces;
import com.microsoft.azure.management.eventgrid.v2020_04_01_preview.PartnerNamespace;
import rx.Observable;
import rx.Completable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import com.microsoft.azure.arm.resources.ResourceUtilsCore;
import com.microsoft.azure.arm.utils.RXMapper;
import rx.functions.Func1;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.eventgrid.v2020_04_01_preview.PartnerNamespaceSharedAccessKeys;

class PartnerNamespacesImpl extends GroupableResourcesCoreImpl<PartnerNamespace, PartnerNamespaceImpl, PartnerNamespaceInner, PartnerNamespacesInner, EventGridManager>  implements PartnerNamespaces {
    protected PartnerNamespacesImpl(EventGridManager manager) {
        super(manager.inner().partnerNamespaces(), manager);
    }

    @Override
    protected Observable<PartnerNamespaceInner> getInnerAsync(String resourceGroupName, String name) {
        PartnerNamespacesInner client = this.inner();
        return client.getByResourceGroupAsync(resourceGroupName, name);
    }

    @Override
    protected Completable deleteInnerAsync(String resourceGroupName, String name) {
        PartnerNamespacesInner client = this.inner();
        return client.deleteAsync(resourceGroupName, name).toCompletable();
    }

    @Override
    public Observable<String> deleteByIdsAsync(Collection<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Observable.empty();
        }
        Collection<Observable<String>> observables = new ArrayList<>();
        for (String id : ids) {
            final String resourceGroupName = ResourceUtilsCore.groupFromResourceId(id);
            final String name = ResourceUtilsCore.nameFromResourceId(id);
            Observable<String> o = RXMapper.map(this.inner().deleteAsync(resourceGroupName, name), id);
            observables.add(o);
        }
        return Observable.mergeDelayError(observables);
    }

    @Override
    public Observable<String> deleteByIdsAsync(String...ids) {
        return this.deleteByIdsAsync(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public void deleteByIds(Collection<String> ids) {
        if (ids != null && !ids.isEmpty()) {
            this.deleteByIdsAsync(ids).toBlocking().last();
        }
    }

    @Override
    public void deleteByIds(String...ids) {
        this.deleteByIds(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public PagedList<PartnerNamespace> listByResourceGroup(String resourceGroupName) {
        PartnerNamespacesInner client = this.inner();
        return this.wrapList(client.listByResourceGroup(resourceGroupName));
    }

    @Override
    public Observable<PartnerNamespace> listByResourceGroupAsync(String resourceGroupName) {
        PartnerNamespacesInner client = this.inner();
        return client.listByResourceGroupAsync(resourceGroupName)
        .flatMapIterable(new Func1<Page<PartnerNamespaceInner>, Iterable<PartnerNamespaceInner>>() {
            @Override
            public Iterable<PartnerNamespaceInner> call(Page<PartnerNamespaceInner> page) {
                return page.items();
            }
        })
        .map(new Func1<PartnerNamespaceInner, PartnerNamespace>() {
            @Override
            public PartnerNamespace call(PartnerNamespaceInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public PagedList<PartnerNamespace> list() {
        PartnerNamespacesInner client = this.inner();
        return this.wrapList(client.list());
    }

    @Override
    public Observable<PartnerNamespace> listAsync() {
        PartnerNamespacesInner client = this.inner();
        return client.listAsync()
        .flatMapIterable(new Func1<Page<PartnerNamespaceInner>, Iterable<PartnerNamespaceInner>>() {
            @Override
            public Iterable<PartnerNamespaceInner> call(Page<PartnerNamespaceInner> page) {
                return page.items();
            }
        })
        .map(new Func1<PartnerNamespaceInner, PartnerNamespace>() {
            @Override
            public PartnerNamespace call(PartnerNamespaceInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public PartnerNamespaceImpl define(String name) {
        return wrapModel(name);
    }

    @Override
    public Observable<PartnerNamespaceSharedAccessKeys> listSharedAccessKeysAsync(String resourceGroupName, String partnerNamespaceName) {
        PartnerNamespacesInner client = this.inner();
        return client.listSharedAccessKeysAsync(resourceGroupName, partnerNamespaceName)
        .map(new Func1<PartnerNamespaceSharedAccessKeysInner, PartnerNamespaceSharedAccessKeys>() {
            @Override
            public PartnerNamespaceSharedAccessKeys call(PartnerNamespaceSharedAccessKeysInner inner) {
                return new PartnerNamespaceSharedAccessKeysImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<PartnerNamespaceSharedAccessKeys> regenerateKeyAsync(String resourceGroupName, String partnerNamespaceName, String keyName) {
        PartnerNamespacesInner client = this.inner();
        return client.regenerateKeyAsync(resourceGroupName, partnerNamespaceName, keyName)
        .map(new Func1<PartnerNamespaceSharedAccessKeysInner, PartnerNamespaceSharedAccessKeys>() {
            @Override
            public PartnerNamespaceSharedAccessKeys call(PartnerNamespaceSharedAccessKeysInner inner) {
                return new PartnerNamespaceSharedAccessKeysImpl(inner, manager());
            }
        });
    }

    @Override
    protected PartnerNamespaceImpl wrapModel(PartnerNamespaceInner inner) {
        return  new PartnerNamespaceImpl(inner.name(), inner, manager());
    }

    @Override
    protected PartnerNamespaceImpl wrapModel(String name) {
        return new PartnerNamespaceImpl(name, new PartnerNamespaceInner(), this.manager());
    }

}
