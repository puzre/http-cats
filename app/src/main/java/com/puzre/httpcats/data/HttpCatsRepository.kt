package com.puzre.httpcats.data

import com.puzre.httpcats.data.model.HttpCat

object HttpCatsRepository {

    fun getAllCodes() = arrayOf(
        arrayOf(
            HttpCat("100", "Continue"),
            HttpCat("101", "Switching Protocols"),
            HttpCat("102", "Processing"),
            HttpCat("103", "Early Hints")
        ),
        arrayOf(
            HttpCat("200", "OK"),
            HttpCat("201", "Created"),
            HttpCat("202", "Accepted"),
            HttpCat("203", "Non-Authoritative Information"),
            HttpCat("204", "No Content"),
            HttpCat("206", "Partial Content"),
            HttpCat("205", "Reset Content"),
            HttpCat("207", "Multi-Status"),
            HttpCat("208", "Already Reported"),
            HttpCat("226", "IM Used")
        ),
        arrayOf(
            HttpCat("300", "Multiple Choices"),
            HttpCat("301", "Moved Permanently"),
            HttpCat("302", "Found"),
            HttpCat("303", "See Other"),
            HttpCat("304", "Not Modified"),
            HttpCat("305", "Use Proxy"),
            HttpCat("307", "Temporary Redirect"),
            HttpCat("308", "Permanent Redirect")
        ),
        arrayOf(
            HttpCat("400", "Bad Request"),
            HttpCat("401", "Unauthorized"),
            HttpCat("402", "Payment Required"),
            HttpCat("403", "Forbidden"),
            HttpCat("404", "Not Found"),
            HttpCat("405", "Method Not Allowed"),
            HttpCat("406", "Not Acceptable"),
            HttpCat("407", "Proxy Authentication Required"),
            HttpCat("408", "Request Timeout"),
            HttpCat("409", "Conflict"),
            HttpCat("410", "Gone"),
            HttpCat("411", "Length Required"),
            HttpCat("412", "Precondition Failed"),
            HttpCat("413", "Payload Too Large"),
            HttpCat("414", "Request-URI Too Long"),
            HttpCat("415", "Unsupported Media Type"),
            HttpCat("416", "Request Range Not Satisfiable"),
            HttpCat("417", "Expectation Failed"),
            HttpCat("418", "I’m a teapot"),
            HttpCat("420", "Enhance Your Calm"),
            HttpCat("421", "Misdirected Request"),
            HttpCat("422", "Unprocessable Entity"),
            HttpCat("423", "Locked"),
            HttpCat("424", "Failed Dependency"),
            HttpCat("425", "Too Early"),
            HttpCat("426", "Upgrade Required"),
            HttpCat("428", "Precondition Required"),
            HttpCat("429", "Too Many Requests"),
            HttpCat("431", "Request Header Fields Too Large"),
            HttpCat("444", "No Response"),
            HttpCat("450", "Blocked by Windows Parental Controls"),
            HttpCat("451", "Unavailable For Legal Reasons"),
            HttpCat("497", "HTTP Request Sent to HTTPS Port"),
            HttpCat("498", "Token expired/invalid"),
            HttpCat("499", "Client Closed Request")
        ),
        arrayOf(
            HttpCat("500", "Internal Server Error"),
            HttpCat("501", "Not Implemented"),
            HttpCat("502", "Bad Gateway"),
            HttpCat("503", "Service Unavailable"),
            HttpCat("504", "Gateway Timeout"),
            HttpCat("506", "Variant Also Negotiates"),
            HttpCat("507", "Insufficient Storage"),
            HttpCat("508", "Loop Detected"),
            HttpCat("509", "Bandwidth Limit Exceeded"),
            HttpCat("510", "Not Extended"),
            HttpCat("511", "Network Authentication Required"),
            HttpCat("521", "Web Server Is Down"),
            HttpCat("522", "Connection Timed Out"),
            HttpCat("523", "Origin Is Unreachable"),
            HttpCat("525", "SSL Handshake Failed"),
            HttpCat("530", "Site Frozen"),
            HttpCat("599", "Network Connect Timeout Error")
        )
    )

}