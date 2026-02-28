package org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute

import org.bukkit.attribute.Attribute
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import taboolib.library.xseries.XAttribute
import kotlin.jvm.optionals.getOrNull

@Requires(classes = ["org.bukkit.attribute.Attribute"])
@PlatformSide(Platform.BUKKIT)
object FnAttribute : FnEnumGetter<Attribute>() {

    override val enumClass: Class<Attribute> = Attribute::class.java

    override fun enumValue(value: String): Attribute? {
        return XAttribute.of(value).getOrNull()?.get()
    }
}
