package org.tabooproject.fluxon

import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake

/**
 * FluxonPlugin
 * org.tabooproject.fluxon.EnvironmentChecker
 *
 * @author mical
 * @since 2026/3/9 23:18
 */
@Requires(classes = ["!org.tabooproject.fluxon.ParseScript"])
object EnvChecker {

    @Awake(LifeCycle.INIT)
    fun init() {
        System.setProperty("fluxon.hasFlxuonPlugin", "true")
    }
}