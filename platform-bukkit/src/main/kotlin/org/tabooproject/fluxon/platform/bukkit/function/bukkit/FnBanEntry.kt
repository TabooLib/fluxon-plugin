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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.BanEntry"])
@PlatformSide(Platform.BUKKIT)
object FnBanEntry {

    val TYPE = Type.fromClass(BanEntry::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BanEntry::class.java)
                .function("target", returnsObject().noParams()) { it.setReturnRef(it.target?.target) }
                .function("banTarget", returnsObject().noParams()) { it.setReturnRef(it.target?.getBanTarget()) }
                .function("created", returnsObject().noParams()) { it.setReturnRef(it.target?.created) }
                .function("setCreated", returnsVoid().params(Type.J)) { it.target?.setCreated(Date(it.getLong(0))) }
                .function("source", returnsObject().noParams()) { it.setReturnRef(it.target?.source) }
                .function("setSource", returnsVoid().params(Type.STRING)) { it.target?.setSource(it.getString(0)!!) }
                .function("expiration", returnsObject().noParams()) { it.setReturnRef(it.target?.expiration) }
                .function("setExpiration", returnsVoid().params(Type.J)) { it.target?.setExpiration(Date(it.getLong(0))) }
                .function("reason", returnsObject().noParams()) { it.setReturnRef(it.target?.reason) }
                .function("setReason", returnsVoid().params(Type.STRING)) { it.target?.setReason(it.getString(0)) }
                .function("save", returnsVoid().noParams()) { it.target?.save() }
                .function("remove", returnsVoid().noParams()) { it.target?.remove() }
        }
    }
}
