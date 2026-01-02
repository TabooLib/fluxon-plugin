package org.tabooproject.fluxon.platform.bukkit.function

import org.bukkit.metadata.Metadatable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.platform.util.getMetaFirstOrNull
import taboolib.platform.util.hasMeta
import taboolib.platform.util.removeMeta
import taboolib.platform.util.setMeta

object FunctionMetadata {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Metadatable::class.java)
                .function("setMeta", 2) {
                    it.target?.setMeta(it.getArgument(0)!!.toString(), it.getArgument(1)!!)
                }
                .function("removeMeta", 1) {
                    it.target?.removeMeta(it.getArgument(0)!!.toString())
                }
                .function("hasMeta", 1) {
                    it.target?.hasMeta(it.getArgument(0)!!.toString())
                }
                .function("getMeta", 1) {
                    it.target?.getMetaFirstOrNull(it.getArgument(0)!!.toString())?.value()
                }
        }
    }
}