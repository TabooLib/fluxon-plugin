package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Note
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.Note"])
@PlatformSide(Platform.BUKKIT)
object FnNote {

    val TYPE = Type.fromClass(Note::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Note::class.java)
                // static
                .function("flat",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNote.TYPE).params(Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNoteTone.TYPE)) { it.setReturnRef(Note.flat(it.getInt(0).toInt(), it.getRef(1) as Note.Tone)) }
                // static
                .function("sharp",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNote.TYPE).params(Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNoteTone.TYPE)) { it.setReturnRef(Note.sharp(it.getInt(0).toInt(), it.getRef(1) as Note.Tone)) }
                // static
                .function("natural",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNote.TYPE).params(Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNoteTone.TYPE)) { it.setReturnRef(Note.natural(it.getInt(0).toInt(), it.getRef(1) as Note.Tone)) }
                .function("sharped",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNote.TYPE).noParams()) { it.setReturnRef(it.target?.sharped()) }
                .function("flattened",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNote.TYPE).noParams()) { it.setReturnRef(it.target?.flattened()) }
                .function("id", returns(Type.I).noParams()) { it.setReturnInt(it.target?.id?.toInt() ?: 0) }
                .function("octave", returns(Type.I).noParams()) { it.setReturnInt(it.target?.octave?.toInt() ?: 0) }
                .function("tone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNoteTone.TYPE).noParams()) { it.setReturnRef(it.target?.tone) }
                .function("isSharped", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSharped ?: false) }
                .function("pitch", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.pitch ?: 0.0f) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}

@Requires(classes = ["org.bukkit.Note\$Tone"])
@PlatformSide(Platform.BUKKIT)
object FnNoteTone : org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter<org.bukkit.Note.Tone>() {

    override val enumClass: Class<org.bukkit.Note.Tone> = org.bukkit.Note.Tone::class.java


    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Note.Tone::class.java)
                .function("getId", returns(Type.I).params(Type.Z)) { it.setReturnInt(it.target?.getId(it.getBool(0))?.toInt() ?: 0) }
                .function("isSharpable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSharpable ?: false) }
                .function("isSharped", returns(Type.Z).params(Type.I)) { it.setReturnBool(it.target?.isSharped(it.getInt(0).toByte()) ?: false) }
                // static
                .function("getById", returns(TYPE).params(Type.I)) { it.setReturnRef(Note.Tone.getById(it.getInt(0).toByte())) }
        }
    }
}
