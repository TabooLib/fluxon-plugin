package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Sound
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.library.xseries.XSound
import kotlin.jvm.optionals.getOrNull
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.Sound"])
@PlatformSide(Platform.BUKKIT)
object FnSound : FnEnumGetter<Sound>() {

    override val enumClass: Class<Sound> = Sound::class.java

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sound::class.java)
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
            registerFunction("sound", returnsObject().params(Type.STRING)) {
                val name = it.getRef(0).toString()
                it.setReturnRef(XSound.of(name).getOrNull()?.get() ?: error("音效不存在: $name"))}
            registerFunction("soundOrNull", returnsObject().params(Type.STRING)) {
                val name = it.getRef(0).toString()
                it.setReturnRef(XSound.of(name).getOrNull()?.get())}
        }
    }

    override fun enumValue(value: String): Sound? {
        return XSound.of(value).getOrNull()?.get()
    }
}
