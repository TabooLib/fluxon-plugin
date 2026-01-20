package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Note
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnNote {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Note::class.java)
                // static
                .function("flat", 2) { Note.flat(it.getNumber(0).toInt(), it.getArgument(1) as Note.Tone) }
                // static
                .function("sharp", 2) { Note.sharp(it.getNumber(0).toInt(), it.getArgument(1) as Note.Tone) }
                // static
                .function("natural", 2) { Note.natural(it.getNumber(0).toInt(), it.getArgument(1) as Note.Tone) }
                .function("sharped", 0) { it.target?.sharped() }
                .function("flattened", 0) { it.target?.flattened() }
                .function("id", 0) {
                    it.target?.id
                }
                .function("octave", 0) { it.target?.octave }
                .function("tone", 0) { it.target?.tone }
                .function("isSharped", 0) { it.target?.isSharped }
                .function("pitch", 0) { it.target?.pitch }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("toString", 0) { it.target?.toString() }

            registerExtension(Note.Tone::class.java)
                .function("id", 1) { it.target?.getId(it.getBoolean(0)) }
                .function("isSharpable", 0) { it.target?.isSharpable }
                .function("isSharped", 1) { it.target?.isSharped(it.getNumber(0).toByte()) }
                // static
                .function("byId", 1) { Note.Tone.getById(it.getNumber(0).toByte()) }
        }
    }
}
