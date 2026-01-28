package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.BanEntry
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.BanEntry"])
@PlatformSide(Platform.BUKKIT)
object FnBanEntry {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BanEntry::class.java)
                .function("target", returnsObject().noParams()) { it.setReturnRef(it.target?.target) }
                .function("banTarget", returnsObject().noParams()) { it.setReturnRef(it.target?.getBanTarget()) }
                .function("created", returnsObject().noParams()) { it.setReturnRef(it.target?.created) }
                .function("setCreated", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCreated(Date(it.getInt(0).toLong()))) }
                .function("source", returnsObject().noParams()) { it.setReturnRef(it.target?.source) }
                .function("setSource", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSource(it.getString(0)!!)) }
                .function("expiration", returnsObject().noParams()) { it.setReturnRef(it.target?.expiration) }
                .function("setExpiration", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setExpiration(Date(it.getInt(0).toLong()))) }
                .function("reason", returnsObject().noParams()) { it.setReturnRef(it.target?.reason) }
                .function("setReason", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setReason(it.getString(0))) }
                .function("save", returnsObject().noParams()) { it.setReturnRef(it.target?.save()) }
                .function("remove", returnsObject().noParams()) { it.setReturnRef(it.target?.remove()) }
        }
    }
}
