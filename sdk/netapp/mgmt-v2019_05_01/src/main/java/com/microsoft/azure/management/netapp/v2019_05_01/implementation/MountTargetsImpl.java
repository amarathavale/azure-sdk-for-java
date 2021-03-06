/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.netapp.v2019_05_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.netapp.v2019_05_01.MountTargets;
import rx.Observable;
import rx.functions.Func1;
import java.util.List;
import com.microsoft.azure.management.netapp.v2019_05_01.MountTarget;

class MountTargetsImpl extends WrapperImpl<MountTargetsInner> implements MountTargets {
    private final NetAppManager manager;

    MountTargetsImpl(NetAppManager manager) {
        super(manager.inner().mountTargets());
        this.manager = manager;
    }

    public NetAppManager manager() {
        return this.manager;
    }

    private MountTargetImpl wrapModel(MountTargetInner inner) {
        return  new MountTargetImpl(inner, manager());
    }

    @Override
    public Observable<MountTarget> listAsync(String resourceGroupName, String accountName, String poolName, String volumeName) {
        MountTargetsInner client = this.inner();
        return client.listAsync(resourceGroupName, accountName, poolName, volumeName)
        .flatMap(new Func1<List<MountTargetInner>, Observable<MountTargetInner>>() {
            @Override
            public Observable<MountTargetInner> call(List<MountTargetInner> innerList) {
                return Observable.from(innerList);
            }
        })
        .map(new Func1<MountTargetInner, MountTarget>() {
            @Override
            public MountTarget call(MountTargetInner inner) {
                return wrapModel(inner);
            }
        });
    }

}
