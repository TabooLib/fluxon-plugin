package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.BlockFace
import org.bukkit.block.data.type.RedstoneWire
import org.tabooproject.fluxon.function.FnEnumGetter
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.util.StandardTypes

@Requires(classes = ["org.bukkit.block.data.type.RedstoneWire"])
@PlatformSide(Platform.BUKKIT)
object FnRedstoneWire {

    val TYPE = Type.fromClass(RedstoneWire::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RedstoneWire::class.java)
                .function("getFace", returns(FnRedstoneWireConnection.TYPE).params(FnBlockFace.TYPE)) { it.setReturnRef(it.target?.getFace(it.getRef(0) as BlockFace)) }
                .function("getFace", returns(FnRedstoneWireConnection.TYPE).params(Type.STRING)) {
                    FnBlockFace.enumValue(it.getString(0))?.let { p0 ->
                        it.setReturnRef(it.target?.getFace(
                            p0))
                    }
                }
                .function("setFace", returnsVoid().params(FnBlockFace.TYPE, FnRedstoneWireConnection.TYPE)) {
                    it.target?.setFace(
                        it.getRef(0) as BlockFace,
                        it.getRef(1) as RedstoneWire.Connection
                    )
                }
                .function("setFace", returnsVoid().params(Type.STRING, FnRedstoneWireConnection.TYPE)) {
                    FnBlockFace.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.setFace(
                            p0,
                            it.getRef(1) as RedstoneWire.Connection
                        )
                    }
                }
                .function("setFace", returnsVoid().params(FnBlockFace.TYPE, Type.STRING)) {
                    FnRedstoneWireConnection.enumValue(it.getString(1))?.let { p1 ->
                        it.target?.setFace(
                            it.getRef(0) as BlockFace,
                            p1
                        )
                    }
                }
                .function("setFace", returnsVoid().params(Type.STRING, Type.STRING)) {
                    val face = FnBlockFace.enumValue(it.getString(0)) ?: return@function
                    val connection = FnRedstoneWireConnection.enumValue(it.getString(1)) ?: return@function
                    it.target?.setFace(face, connection)
                }
                .function("allowedFaces", returns(StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.allowedFaces) }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.type.RedstoneWire.Connection"])
@PlatformSide(Platform.BUKKIT)
object FnRedstoneWireConnection : FnEnumGetter<RedstoneWire.Connection>() {

    override val enumClass: Class<RedstoneWire.Connection> = RedstoneWire.Connection::class.java
}