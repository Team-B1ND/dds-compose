package com.b1nd.dodam.designsystem.foundation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.b1nd.dodam.designsystem.resources.Res
import com.b1nd.dodam.designsystem.resources.ic_arrow_left
import com.b1nd.dodam.designsystem.resources.ic_bell
import com.b1nd.dodam.designsystem.resources.ic_bus
import com.b1nd.dodam.designsystem.resources.ic_calendar
import com.b1nd.dodam.designsystem.resources.ic_chart
import com.b1nd.dodam.designsystem.resources.ic_checkmark
import com.b1nd.dodam.designsystem.resources.ic_checkmark_circle
import com.b1nd.dodam.designsystem.resources.ic_checkmark_circle_filled
import com.b1nd.dodam.designsystem.resources.ic_chevron_left
import com.b1nd.dodam.designsystem.resources.ic_chevron_right
import com.b1nd.dodam.designsystem.resources.ic_close_line
import com.b1nd.dodam.designsystem.resources.ic_colored_checkmark_circle_filled
import com.b1nd.dodam.designsystem.resources.ic_colored_clock
import com.b1nd.dodam.designsystem.resources.ic_colored_xmark_circle
import com.b1nd.dodam.designsystem.resources.ic_crown
import com.b1nd.dodam.designsystem.resources.ic_dev
import com.b1nd.dodam.designsystem.resources.ic_door_open
import com.b1nd.dodam.designsystem.resources.ic_download
import com.b1nd.dodam.designsystem.resources.ic_exclamationmark_circle
import com.b1nd.dodam.designsystem.resources.ic_eye
import com.b1nd.dodam.designsystem.resources.ic_eye_slash
import com.b1nd.dodam.designsystem.resources.ic_file
import com.b1nd.dodam.designsystem.resources.ic_fork_and_knife
import com.b1nd.dodam.designsystem.resources.ic_full_moon_face
import com.b1nd.dodam.designsystem.resources.ic_gear
import com.b1nd.dodam.designsystem.resources.ic_globe
import com.b1nd.dodam.designsystem.resources.ic_home
import com.b1nd.dodam.designsystem.resources.ic_magnifyingglass
import com.b1nd.dodam.designsystem.resources.ic_megaphone
import com.b1nd.dodam.designsystem.resources.ic_menu
import com.b1nd.dodam.designsystem.resources.ic_moon_plus
import com.b1nd.dodam.designsystem.resources.ic_note
import com.b1nd.dodam.designsystem.resources.ic_pen
import com.b1nd.dodam.designsystem.resources.ic_person
import com.b1nd.dodam.designsystem.resources.ic_photo
import com.b1nd.dodam.designsystem.resources.ic_plus
import com.b1nd.dodam.designsystem.resources.ic_silhouette
import com.b1nd.dodam.designsystem.resources.ic_trash
import com.b1nd.dodam.designsystem.resources.ic_xmark_circle
import org.jetbrains.compose.resources.vectorResource

enum class DodamIcons {
    Home,
    ForkAndKnife,
    DoorOpen,
    Calendar,
    MoonPlus,
    Menu,
    XMarkCircle,
    ExclamationMarkCircle,
    Plus,
    Note,
    Bus,
    Megaphone,
    ArrowLeft,
    Bell,
    Eye,
    EyeSlash,
    Checkmark,
    CheckmarkCircle,
    CheckmarkCircleFilled,
    ChevronRight,
    ChevronLeft,
    Trash,
    MagnifyingGlass,
    Gear,
    Person,
    Dev,
    Close,
    FullMoonFace,
    Pen,
    Chart,
    File,
    Photo,
    Crown,
    ColorXMark,
    ColorCheckMark,
    Silhouette,
    Clock,
    Download,
    Globe;

    val value: ImageVector
        @Composable
        get() = when (this) {
            Home -> vectorResource(Res.drawable.ic_home)
            ForkAndKnife -> vectorResource(Res.drawable.ic_fork_and_knife)
            DoorOpen -> vectorResource(Res.drawable.ic_door_open)
            Calendar -> vectorResource(Res.drawable.ic_calendar)
            MoonPlus -> vectorResource(Res.drawable.ic_moon_plus)
            Menu -> vectorResource(Res.drawable.ic_menu)
            XMarkCircle -> vectorResource(Res.drawable.ic_xmark_circle)
            ExclamationMarkCircle -> vectorResource(Res.drawable.ic_exclamationmark_circle)
            Plus -> vectorResource(Res.drawable.ic_plus)
            Note -> vectorResource(Res.drawable.ic_note)
            Bus -> vectorResource(Res.drawable.ic_bus)
            Megaphone -> vectorResource(Res.drawable.ic_megaphone)
            ArrowLeft -> vectorResource(Res.drawable.ic_arrow_left)
            Bell -> vectorResource(Res.drawable.ic_bell)
            Eye -> vectorResource(Res.drawable.ic_eye)
            EyeSlash -> vectorResource(Res.drawable.ic_eye_slash)
            Checkmark -> vectorResource(Res.drawable.ic_checkmark)
            CheckmarkCircle -> vectorResource(Res.drawable.ic_checkmark_circle)
            CheckmarkCircleFilled -> vectorResource(Res.drawable.ic_checkmark_circle_filled)
            ChevronRight -> vectorResource(Res.drawable.ic_chevron_right)
            ChevronLeft -> vectorResource(Res.drawable.ic_chevron_left)
            Trash -> vectorResource(Res.drawable.ic_trash)
            MagnifyingGlass -> vectorResource(Res.drawable.ic_magnifyingglass)
            Gear -> vectorResource(Res.drawable.ic_gear)
            Person -> vectorResource(Res.drawable.ic_person)
            Dev -> vectorResource(Res.drawable.ic_dev)
            Close -> vectorResource(Res.drawable.ic_close_line)
            FullMoonFace -> vectorResource(Res.drawable.ic_full_moon_face)
            Pen -> vectorResource(Res.drawable.ic_pen)
            Chart -> vectorResource(Res.drawable.ic_chart)
            File -> vectorResource(Res.drawable.ic_file)
            Photo -> vectorResource(Res.drawable.ic_photo)
            Crown -> vectorResource(Res.drawable.ic_crown)
            Silhouette -> vectorResource(Res.drawable.ic_silhouette)
            Clock -> vectorResource(Res.drawable.ic_colored_clock)
            ColorXMark -> vectorResource(Res.drawable.ic_colored_xmark_circle)
            ColorCheckMark -> vectorResource(Res.drawable.ic_colored_checkmark_circle_filled)
            Download -> vectorResource(Res.drawable.ic_download)
            Globe -> vectorResource(Res.drawable.ic_globe)
        }
}
